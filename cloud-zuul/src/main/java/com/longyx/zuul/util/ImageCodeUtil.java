package com.longyx.zuul.util;

import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * @program: cloud_manage_lyx
 * @author: Mr.Michael
 * @create: 2019-12-19 10:31
 **/
@Component
public class ImageCodeUtil {
    private int width = 100;
    private int height = 50;
    /**记录随机字符*/
    private String text;
    private Random random = new Random();
    private String[] fontNames = {"Georgia","宋体","楷体","隶书","微软雅黑"};
    private Color bgColor = new Color(255,255,255);
    private String codes = "23456789abcdefghjkmnopqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ";

    /**
     * 获取随机的颜色
     *
     * @return
     */
    private Color randomColor() {
        int red = this.random.nextInt(150);
        int green = this.random.nextInt(150);
        int blue = this.random.nextInt(150);
        return new Color(red, green, blue);
    }

    /**
     * 获取随机字体
     *
     * @return
     */
    private Font randomFont() {
        int index = random.nextInt(fontNames.length);
        String fontName = fontNames[index];
        int style = random.nextInt(4);
        int size = random.nextInt(5) + 24;
        return new Font(fontName, style, size);
    }

    /**
     * 获取随机字符
     *
     * @return
     */
    private char randomChar() {
        int index = random.nextInt(codes.length());
        return codes.charAt(index);
    }

    /**
     * 画干扰线，验证码干扰线用来防止计算机解析图片
     *
     * @param image
     */
    private void drawLine(BufferedImage image) {
        // 干扰线的数量
        int num = random.nextInt(10);
        Graphics2D g = (Graphics2D) image.getGraphics();
        for (int i = 0; i < num; i++) {
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(height);
            g.setColor(randomColor());
            g.setStroke(new BasicStroke(1.5f));
            g.drawLine(x1, y1, x2, y2);
        }
    }

    /**
     * 创建图片的方法
     *
     * @return
     */
    private BufferedImage createImage() {
        //创建图片缓冲区
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //获取画笔
        Graphics2D g = (Graphics2D) image.getGraphics();
        //设置背景色随机
//        g.setColor(new Color(255, 255, random.nextInt(245) + 10));
        g.setColor(bgColor);
        g.fillRect(0, 0, width, height);
        //返回一个图片
        return image;
    }

    /**
     * 获取验证码图片的方法
     *
     * @return
     */
    public BufferedImage getImage() {
        BufferedImage image = createImage();
        Graphics2D g = (Graphics2D) image.getGraphics();
//        StringBuilder sb = new StringBuilder();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            String s = randomChar() + "";
            sb.append(s);
            float x = i * 1.0F * width / 4;
            g.setFont(randomFont());
            g.setColor(randomColor());
            g.drawString(s, x, height - 5);
        }
        this.text = sb.toString();
        drawLine(image);
        return image;
    }

    public String getText() {
        return this.text;
    }

    public void output(BufferedImage image, OutputStream out) throws IOException {
        ImageIO.write(image, "JPEG", out);
    }
}


