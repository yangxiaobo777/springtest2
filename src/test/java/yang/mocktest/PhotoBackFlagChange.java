package yang.mocktest;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author yang
 * @className PhotoBackFlagChange
 * @description TODO
 * @date 2021/8/3 17:16
 * @Version 1.0
 */
public class PhotoBackFlagChange {
    public static void main(String[] args) throws IOException {

        File dir = new File("D:/img");

        File[] files = dir.listFiles();

        for (int i = 0; i < files.length ; i++) {

            int[] rgb = new int[3];

            BufferedImage bi = null;

            try {
                bi = ImageIO.read(files[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }

            int width = bi.getWidth();
            int height = bi.getHeight();
            int minX = bi.getMinX();
            int minY = bi.getMinY();

            System.out.println("正在处理:"+files[i].getName());


            for (int j = minX; j < width ; j++) {
                for (int k = minY; k <height ; k++) {
                    int pixe = bi.getRGB(j, k);

                    rgb[0] = (pixe & 0xff0000) >> 16;
                    rgb[1] = (pixe & 0xff00) >> 8;
                    rgb[2] = (pixe & 0xff);

                    if((rgb[0] < 96 && rgb[2] > 100 )){
                        bi.setRGB(j,k,0xffffff);
                    }
                }
            }

            System.out.println("\t处理完毕"+files[i].getName());

            FileOutputStream fileOutputStream = new FileOutputStream(new File("D:/img/new_" + files[i].getName()));
            ImageIO.write(bi,"jpg",fileOutputStream);

            fileOutputStream.flush();
            fileOutputStream.close();
        }
    }
}
