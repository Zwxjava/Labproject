package main.java.utils;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
 
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetImage
 */
@WebServlet("/ImageServlet")
public class ImageServlet extends HttpServlet {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// ͼƬ�߶�
    private static final int IMG_HEIGHT = 100;
    // ͼƬ���
    private static final int IMG_WIDTH = 30;
    // ��֤�볤��
    private static final int CODE_LEN = 4;
 
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }
 
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // ���ڻ���ͼƬ������ͼƬ�ĳ����ͼƬ���ͣ�RGB)
        BufferedImage bi = new BufferedImage(IMG_HEIGHT, IMG_WIDTH, BufferedImage.TYPE_INT_RGB);
        // ��ȡ��ͼ����
        Graphics graphics = bi.getGraphics();
        graphics.setColor(new Color(100, 230, 200)); // ʹ��RGB���ñ�����ɫ
        graphics.fillRect(0, 0, 100, 30); // ����������
 
        // ��֤������ʹ�õ����ַ�
        char[] codeChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456".toCharArray();
        String captcha = ""; // ������ɵ���֤��
        Random random = new Random();
        for(int i = 0; i < CODE_LEN; i++) { // ѭ����ÿ����֤���ַ����Ƶ�ͼƬ��
            int index = random.nextInt(codeChar.length);
            // ���������֤����ɫ
            graphics.setColor(new Color(random.nextInt(150), random.nextInt(200), random.nextInt(255)));
            // ��һ���ַ����Ƶ�ͼƬ�ϣ����ƶ�λ�ã�����x,y���꣩
            graphics.drawString(codeChar[index] + "", (i * 20) + 15, 20);
            captcha += codeChar[index];
        }
        // �����ɵ���֤��code����sessoin��
        req.getSession().setAttribute("code", captcha); 
       
        // ͨ��ImageIO��ͼƬ���
        ImageIO.write(bi, "JPG", resp.getOutputStream());
    }
 
}

