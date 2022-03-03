package me.mikholskiy.task12;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class HashGen {
	@Value("#{ springApplicationArguments.sourceArgs[0] }")
	private String src;
	@Value("#{ springApplicationArguments.sourceArgs[1] }")
	private String dest;

	/**
	 * Создает второй файл, если его не существует.
	 */
	@PostConstruct
	private void postConstruct() throws IOException {
		System.out.println("Post doing something");

		if (!new File(src).exists()) {
			File destFile = new File(dest);
			if (!destFile.createNewFile()) {
				try (var writer = new FileWriter(dest, false)) {
					writer.write("null");
				}
			}
		} else {
			try (FileWriter writer = new FileWriter(dest, false)) {
				StringBuilder builder = new StringBuilder();
				try (FileReader reader = new FileReader(src)) {
					int c;
					while ((c = reader.read()) != -1) {
						builder.append(c << 21);
					}
				}
				writer.write(builder.toString());
			}
		}
	}

	/**
	 * Удаляет исходный файл с нехэшированными данными
	 */
	@PreDestroy
	private void preDestroy() throws IOException {
		System.out.println("Pre doing something");

		Files.deleteIfExists(Paths.get(src));
	}
}
