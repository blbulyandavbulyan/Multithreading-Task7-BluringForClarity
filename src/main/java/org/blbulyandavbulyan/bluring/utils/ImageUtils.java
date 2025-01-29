package org.blbulyandavbulyan.bluring.utils;

import org.blbulyandavbulyan.bluring.task.ForkBlur;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ForkJoinPool;

public class ImageUtils {
    public static BufferedImage readImage(String path) throws IOException {
        return ImageIO.read(new File(path));
    }

    public static void writeImage(BufferedImage image, String path) throws IOException {
        ImageIO.write(image, "png", new File(path));
    }

    public static BufferedImage blur(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        int[] src = image.getRGB(0, 0, width, height, null, 0, width);
        int[] dst = new int[src.length];
        ForkBlur forkBlur = new ForkBlur(src, 0, src.length, dst);
        ForkJoinPool.commonPool().invoke(forkBlur);
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        bufferedImage.setRGB(0, 0, width, height, dst, 0, width);
        return bufferedImage;
    }
}
