package me.mikholsky.task7.facade;

public class CodecFactory {
	public static Codec extract(VideoFile file) {
		String type = file.getCodecType();
		if (type.equals("mp4")) {
			System.out.println("CodecFactory: extracting mp4 file...");
			return new MPEG4CompressionCodec();
		} else {
			System.out.println("CodecFactory: extracting ogg file...");
			return new OggCompressionCodec();
		}
	}
}
