package me.mikholsky.task7;

/* Вариант 4
 * 1. Декоратор
 * 2. Фасад */

import me.mikholsky.task7.decorator.*;
import me.mikholsky.task7.facade.VideoConversionFacade;

import java.io.File;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		/* Декоратор */

		Coffee coffee =
				new Water(
						new Milk(
								new CoffeeBean()));

		coffee = new Cinnamon(coffee);

		coffee = new Caramel(coffee);

		coffee.getComposition().forEach(System.out::println);


		IntStream.range(0, 3).forEach(i -> System.out.println());


		VideoConversionFacade conversionFacade = new VideoConversionFacade();
		File mp4Video = conversionFacade.convertVideo("youtube-video.ogg", "mp4");
		System.out.println(mp4Video.getName());
	}
}
