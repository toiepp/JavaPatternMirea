package me.mikholskiy;

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
public class Hasher {
	private final String src;
	private final String dest;

	public Hasher(String src, String dest) {
		this.src = src;
		this.dest = dest;
	}

	public void info() {
		System.out.println(src);
		System.out.println(dest);
	}

	/**
	 * Создает второй файл, если его не существует.
	 */
	@PostConstruct
	private void postConstruct() throws IOException {
		System.out.println("Post doing something");

		if (!new File(src).exists()) {
			File destFile = new File(dest);
			if (destFile.createNewFile()) {
				try (var writer = new FileWriter(dest, false)) {
					writer.write("null");
				}
			}
			return;
		}

		try (FileWriter writer = new FileWriter(dest, false)) {
			StringBuilder builder = new StringBuilder();
			try (FileReader reader = new FileReader(src)) {
				int c;
				while ((c = reader.read()) != -1) {
					builder.append(c << 21 & 0xff);
				}
			}
			writer.write(builder.toString());
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
