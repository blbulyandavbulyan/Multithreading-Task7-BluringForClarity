package org.blbulyandavbulyan.bluring;

import java.awt.image.BufferedImage;
import java.io.IOException;

import static org.blbulyandavbulyan.bluring.utils.ImageUtils.*;

public class Main {
    public static void main(String[] args) {
        if (args.length == 2) {
            try {
                final String inputFilename = args[0];
                final String outputFilename = args[1];
                System.out.printf("Reading input file: %s%n", inputFilename);
                BufferedImage inputImage = readImage(inputFilename);
                System.out.println("Blurring the image...");
                BufferedImage blurredImage = blur(inputImage);
                System.out.printf("Writing to output file: %s%n", outputFilename);
                writeImage(blurredImage, outputFilename);
                System.out.println("Blurred image saved");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            System.err.println("Should specify arguments: [inputImage] [outputImage], where [inputImage] - stands for for path to an input image and [outputImage] stands for a path to an [outputImage]");
        }
    }
}