package com.hujiang.project.zhgd;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.jsoup.Jsoup;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.pdf.BaseFont;

/**
 * 转换html为pdf
 * @author Uncle Liu
 *
 */
public class Htmlpdf {

    /**
     * 将HTML转成PD格式的文件。html文件的格式比较严格
     * @param htmlFile
     * @param pdfFile
     * @throws Exception
     */
    // <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd ">
    public static void html2pdf(String htmlFile, String pdfFile) throws Exception {
        // step 1
        String url = new File(htmlFile).toURI().toURL().toString();
        System.out.println(url);
        // step 2
        OutputStream os = new FileOutputStream(pdfFile);
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocument(url);

        // step 3 解决中文支持
        ITextFontResolver fontResolver = renderer.getFontResolver();
        if("linux".equals(getCurrentOperatingSystem())){
            //Linux下的和Windows的不一样，要自己下载，不要拷贝Windows的到Linux
            fontResolver.addFont("/usr/share/fonts/chiness/simsun.ttc", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        }else{
            fontResolver.addFont("C:\\Windows\\WinSxS\\amd64_microsoft-windows-font-truetype-simsun_31bf3856ad364e35_10.0.17134.1_none_e089ab61d8d9374e\\simsun.ttc", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        }

        renderer.layout();
        renderer.createPDF(os);
        os.close();

        System.out.println("create pdf done!!");

    }

    public static String getCurrentOperatingSystem(){
        String os = System.getProperty("os.name").toLowerCase();
        System.out.println("---------当前操作系统是-----------" + os);
        return os;
    }


    public static void main(String[] args) {

        String htmlFile = "E:\\workspace\\ZHGD\\user-consumer-01\\src\\main\\resources\\templates\\PDF\\jyldht.html";
        String pdfFile = "c:/test.pdf";
        try {
            Htmlpdf.html2pdf(htmlFile, pdfFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
