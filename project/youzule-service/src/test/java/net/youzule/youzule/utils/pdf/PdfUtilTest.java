/*
package net.youzule.youzule.utils.pdf;

import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.forms.fields.PdfFormField;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.text.pdf.BaseFont;
import net.youzule.youzule.YouzuleServiceApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

*/
/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/6/1 14:27
 **//*


@RunWith(SpringRunner.class)
@SpringBootTest(classes = YouzuleServiceApplication.class)
public class PdfUtilTest {


    @Value("${fontpath}")
    private String fontPath;

    @Test
    public void test() throws Exception {
        //模板路径
        String templatePath = "C:/pdf/05-29/template/template.pdf";
        //生成文件路径
        String productionPath = "C:/pdf/05-29/production/production.pdf";

        //要插入的值
        Map<String, Object> values = new HashMap<String, Object>();
        values.put("name", "凉凉哈哈凉凉");
        values.put("age", 12);
        values.put("gender", "man");
        values.put("address", "dd");
        System.out.println(fontPath);
        //字体
        PdfFont font = PdfFontFactory.createFont(ResourceUtils.getURL(fontPath).getPath(), BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

        PdfReader pdfReader = new PdfReader(templatePath);
        PdfWriter pdfWriter = new PdfWriter(productionPath);
        PdfDocument pdfDocument = new PdfDocument(pdfReader, pdfWriter);
        //不存在创建pdf
        PdfAcroForm pdfAcroForm = PdfAcroForm.getAcroForm(pdfDocument, true);


        //获取pdf字段
        Map<String, PdfFormField> map = pdfAcroForm.getFormFields();


        //遍历map
        for (Map.Entry<String, PdfFormField> item : map.entrySet()) {
            //获取表单字段，并赋值
            PdfFormField field = item.getValue();
            String value = String.valueOf(values.get(item.getKey()));
            field.setValue(value);
            field.setFont(font);
        }
        //表单不可编辑
        pdfAcroForm.flattenFields();
        pdfDocument.close();
        pdfReader.close();
        pdfWriter.close();
    }
}
*/
