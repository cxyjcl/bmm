package org.dmm.utils.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Fiona on 2016/9/22.
 */
@RestController
public class VerifyCode {

    final int width = 80;
    final int height = 33;
    static String code = "0123456789asdfghjklqwertyuiopzxcvbnmASDFGHJKLQWERTYUIOPZXCVBNM";
    Random random = new Random();
    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    Graphics g = image.getGraphics();

    private Color generateColor() {
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);
        return new Color(r, g, b);
    }

    private StringBuffer creatImage() {
        g.setColor(Color.white);
        g.fillRect(0, 0, width, height);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        creatLine();
        StringBuffer generateCode = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            g.setColor(generateColor());
            String tempCode = String.valueOf(code.charAt(random.nextInt(30))) + "";
            g.drawString(tempCode, i * width / 4, height - 4);
            generateCode.append(tempCode);
        }
        return generateCode;
    }

    private void creatLine() {
        for (int i = 0; i < 6; i++) {
            g.setColor(generateColor());
            int x1 = (int) (random.nextInt(width));
            int y1 = (int) (random.nextInt(height));
            int x2 = (int) (random.nextInt(width));
            int y2 = (int) (random.nextInt(height));
            g.drawLine(x1, y1, x2, y2);
        }
    }

    @GetMapping("/code/verify")
    public void creatVerifyCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setDateHeader("expries", -1);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        HttpSession session = request.getSession();
        StringBuffer generateCode = new StringBuffer();
        generateCode = creatImage();
        session.setAttribute("generateCode", generateCode);
        ImageIO.write(image, "jpg", response.getOutputStream());
    }

    public static StringBuffer createCode(int count) {
        StringBuffer generateCode = new StringBuffer();
        for (int i = 0; i < count; i++) {
            Random random = new Random();
            String tempCode = String.valueOf(code.charAt(random.nextInt(30))) + "";
            generateCode.append(tempCode);
        }
        return generateCode;
    }
}
