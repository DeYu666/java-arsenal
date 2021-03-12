package com.educhain.test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class RadarMap {

    public static Graphics2D drawRadar(Graphics2D backG, int x, int y, int length){
        backG.drawLine(x, y, (int) (x + (length/2 * 1.732)), y + (length/2));
        backG.drawLine((int) (x + (length/2 * 1.732)), y + (length/2), (int) (x + (length/2 * 1.732)), y + (length/2) + length );
        backG.drawLine( (int) (x + (length/2 * 1.732)), y + (length/2) + length , x, y + (length * 2));

        backG.drawLine(x, y + (length * 2), (int) (x - (length/2 * 1.732)), y + (length/2) + length);
        backG.drawLine((int) (x - (length/2 * 1.732)), y + (length/2) + length, (int) (x - (length/2 * 1.732)), y + (length/2));
        backG.drawLine((int) (x - (length/2 * 1.732)), y + (length/2),x, y);

        return backG;
    }
    public static Graphics2D drawRadarLine(Graphics2D backG, int x, int y, int length){


        backG.drawLine(x, y, x, y + (length * 2));
        backG.drawLine((int) (x + (length/2 * 1.732)), y + (length/2), (int) (x - (length/2 * 1.732)), y + (length/2) + length );
        backG.drawLine( (int) (x + (length/2 * 1.732)), y + (length/2) + length , (int) (x - (length/2 * 1.732)), y + (length/2));

        return backG;
    }

    public static int[] cal(int x1, int y1, int x2, int y2, int g){
        int[] res = new int[2];

        res[0] = (int) ((((x2 - x1 + 0F))/100.0) * g) + x1;
        res[1] = (int) ((((y2 - y1 + 0F))/100.0) * g) + y1;
        return res;
    }

    public static void draw(String outFilePath, int[] g) throws IOException {
        int width = 400, height = 400;
        //创建图片对象
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
        File outFile = new File(outFilePath);

        // 假如目标路径不存在,则新建该路径
        if (!outFile.getParentFile().exists()) {
            outFile.getParentFile().mkdirs();
        }

        // 假如目标文件不存在,则新建该文件
        if (!outFile.exists()) {
            outFile.createNewFile();
        }

        int x = 200;
        int y = 50;
        int length = 150;

        Graphics2D backG = image.createGraphics();

        backG.setColor(Color.GRAY);

        backG = drawRadarLine(backG,x,y,length);
        for (int i = 0; i < 5; i++){
            backG = drawRadar(backG,x,y + (i * 30),length - (i * 30));
        }
        backG.setColor(Color.BLACK);
        for (int i = 0; i < 6; i++){
            backG.drawString(i*20+"",x+30, y + (i * 30) + ((length - (i * 30)) * 2)  -  length + 5 );
        }

        backG.setColor(Color.BLACK);

        int x0 = x;
        int y0 = y + length;

        int[] d1 = cal(x0, y0, x, y, g[0]);
        int[] d2 = cal(x0, y0, (int) (x + (length/2 * 1.732)), y + (length/2), g[1]);
        int[] d3 = cal(x0, y0, (int) (x + (length/2 * 1.732)), y + (length/2) + length, g[2]);
        int[] d4 = cal(x0, y0, x, y + (length * 2), g[3]);
        int[] d5 = cal(x0, y0, (int) (x - (length/2 * 1.732)), y + (length/2) + length, g[4]);
        int[] d6 = cal(x0, y0, (int) (x - (length/2 * 1.732)), y + (length/2), g[5]);

        int[][] dd = new int[][]{d1,d2,d3,d4,d5,d6};


        for (int i = 0; i< dd.length-1; i++){
            backG.drawLine(dd[i][0], dd[i][1], dd[i+1][0], dd[i+1][1]);
        }
        backG.drawLine(dd[dd.length-1][0], dd[dd.length-1][1], dd[0][0], dd[0][1]);
        backG.dispose();
        ImageIO.write(image, "png", new File(outFilePath));
    }


    public static void main(String[] args) {
        try {
            int[] g = new int[]{20,20,20,20,70,90};
            draw("./cert.png", g);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
