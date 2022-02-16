package me.mikholsky.task7.facade;

import java.io.File;

public class VideoConversionFacade {
	public File convertVideo(String fileName, String format) {
		System.out.println("VideoConversionFacade: conversion starts...");

		VideoFile file = 	new VideoFile(fileName);

		Codec sourceCodec = CodecFactory.extract(file);
		Codec destinationCodec;

		if (format.equals("mp4")) {
			destinationCodec = new MPEG4CompressionCodec();
		} else {
			destinationCodec = new OggCompressionCodec();
		}

		VideoFile buffer = BitrateReader.read(file, sourceCodec);
		VideoFile intermediateResult = BitrateReader.convert(buffer, destinationCodec);

		File result = new AudioMixer().fix(intermediateResult);

		System.out.println("VideoConversionFacade: conversion complete.");
		return result;
	}
}
