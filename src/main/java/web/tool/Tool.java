package web.tool;
 
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
 
public class Tool {
  
  /**
   * 현재 시간과 지정된 시간 비교 후 라디오 버튼 비활성화
   */
  public static synchronized String optionradio(int rtime){
    Date dt = new Date();
    int nowtime =  Integer.parseInt(dt.toString().substring(11, 13));
    String a="";
    if(nowtime >= rtime){
      a= "disabled";
    }else{
      a = "";
    }
    return a;
  }
  
  
  /**
   * �깭洹몄쓽 湲곕뒫�쓣 �떒�닚留� 臾몄옄濡� �몴�쁽�븯�뿬 異쒕젰�빀�땲�떎.
   * @param str
   * @return
   */
  public static synchronized String convertChar(String str){
    str = str.replaceAll("<", "& lt;");
    str = str.replaceAll(">", "& gt;");
    str = str.replaceAll("'", "& #39;");     // '
    str = str.replaceAll("\"", "& quot;"); // "
    str = str.replaceAll("\r\n", "<BR>");
    
    return str;
  }
  
  /**
   * 臾몄옄�뿴�씠 null�씠硫� 怨듬갚�쑝濡� 由ы꽩�릺怨�, null�씠 �븘�땲硫� �썝蹂� 臾몄옄�뿴�씠
   * 由ы꽩�맗�땲�떎.
   * @param str
   * @return
   */
  public static synchronized String checkNull(String str){
    if (str == null){
      return "";  // null -> "null" 諛⑹�
    }else if (str.equals("null")){
      return "";
    }else{
      return str;
    }
  }
  
  /**
   * 二쇱뼱吏� �궇吏쒖� 湲곌컙�쓣 怨꾩궛�븯�뿬 �깉湲� �뿬遺� �뙋�떒
   * �쁽�옱 �궇吏쒓� 2013-02-04, 湲��쓣 �벑濡앸궇吏� 2013-02-02
   * isNew("2013-02-04", 2) : 湲� �옉�꽦 �썑 2�� �쟾源뚯� �깉湲� 泥섎━ 
   * 
   * @param date 臾몄옄�뿴濡� �맂 �궇吏�
   * @param period �깉湲�濡� 吏��젙�븷 湲곌컙
   * @return
   */
  public static synchronized boolean isNew(String date, int period) {
    boolean sw = false;
 
    Date _date = new Date();
    // �닽�옄 �삎�깭�씤 �궇吏쒕�� '�뀈�썡�씪 �떆遺꾩큹'�쓽 �삎�깭濡� 蹂��솚
    SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
    try {
      _date = sd.parse(date);
    } catch (Exception e) {
    }
    // System.out.println(date);
    // 1970�뀈1�썡1�씪遺��꽣 �떆媛꾩쓣 1000�쓣 1珥덈줈�븯�뿬 怨꾩궛�븯�뿬 由ы꽩
    long time = _date.getTime(); // 湲��쓣 �옉�꽦�븳 �떆媛�
 
    // �쁽�옱 �떆媛꾩쓣 1970�뀈 1�썡 1�씪遺��꽣 �닔移섑삎�떇�쑝濡� 由ы꽩
    long currentTime = System.currentTimeMillis();
 
    // �쁽�옱 �떆媛꾧낵 湲� �벑濡앹떆媛꾩쓽 李⑥씠瑜� 怨꾩궛
    long diff = currentTime - time;
 
    // 1�씪 86,400,000: 1珥덈�� 1000�쑝濡� �븯猷⑤�� 怨꾩궛
 
    // ceil: �븘二� �옉�� �냼�닔�젏�씠 �엳�뼱�룄 �젙�닔濡� 諛섏삱由� 泥섎━�맖.
    // 0.0001 --> 1: �삤�뒛 �궇吏�
    // 1.00002 --> 2: �뼱�젣 �궇吏�
    int day = (int) Math.ceil(((double) diff / 86400000)); // 吏��궃 �궇吏� 怨꾩궛
 
    if (day <= period) {
      sw = true; // 理쒖떊湲� 泥섎━
    }
    return sw;
  }
 
  /**
   * �씠誘몄� �뙆�씪�씤吏� 寃��궗�빀�땲�떎.
   * @param filename 寃��궗�븷 �뙆�씪紐�
   * @return
   */
  public static synchronized boolean isImage(String filename){
    boolean bol = false;  // �씠誘몄� �뿬遺� ���옣
    
    filename = filename.toLowerCase(); // �냼臾몄옄濡� 蹂�寃�
    
    if (filename.endsWith(".jpg") ||
        filename.endsWith(".jpeg") ||
        filename.endsWith(".png") ||
        filename.endsWith(".gif") ||
        filename.endsWith(".bmp")){
      bol = true;
    }
    
    return bol;
  }
  
  /**
   * �씠誘몄� �궗�씠利덈�� 蹂�寃쏀븯�뿬 �깉濡쒖슫 �씠誘몄�瑜� �깮�꽦�빀�땲�떎.
   * @param src �썝蹂� �씠誘몄�
   * @param dest �깮�꽦�릺�뒗 �씠誘몄�
   * @param width �깮�꽦�맆 �씠誘몄� �꼫鍮�
   * @param height �깮�꽦�맆 �씠誘몄� �넂�씠, ImageUtil.RATIO�뒗 �옄�룞 鍮꾨� 鍮꾩쑉
   * @throws IOException
   */
  public static synchronized String imgResize(File src, File dest, int width, int height) {
    int RATIO = 0;
    int SAME = -1;
    
    Image srcImg = null;
    // �뙆�씪�쓽 �솗�옣�옄 異붿텧
    String name = src.getName().toLowerCase(); // �뙆�씪紐� 異붿텧
    // �씠誘몄� �뙆�씪�씤吏� 寃��궗
    if (name.endsWith("jpg") || name.endsWith("bmp") || name.endsWith("png") || name.endsWith("gif")) {
      try {
        srcImg = ImageIO.read(src); // 硫붾え由ъ뿉 �썝蹂� �씠誘몄� �깮�꽦
        int srcWidth = srcImg.getWidth(null);   // �썝蹂� �씠誘몄� �꼫鍮� 異붿텧
        int srcHeight = srcImg.getHeight(null); // �썝蹂� �씠誘몄� �넂�씠 異붿텧
        int destWidth = -1, destHeight = -1;    // ���긽 �씠誘몄� �겕湲� 珥덇린�솕
        
        if (width == SAME) {    // width媛� 媛숈� 寃쎌슦
          destWidth = srcWidth;
        } else if (width > 0) {
          destWidth = width;    // �깉濡쒖슫 width瑜� �븷�떦
        }
        
        if (height == SAME) {    // �넂�씠媛� 媛숈� 寃쎌슦
          destHeight = srcHeight;
        } else if (height > 0) {
          destHeight = height;  // �깉濡쒖슫 �넂�씠濡� �븷�떦
        }
        
        // 鍮꾩쑉�뿉 �뵲瑜� �겕湲� 怨꾩궛
        if (width == RATIO && height == RATIO) {
          destWidth = srcWidth;
          destHeight = srcHeight;
        } else if (width == RATIO) {
          double ratio = ((double) destHeight) / ((double) srcHeight);
          destWidth = (int) ((double) srcWidth * ratio);
        } else if (height == RATIO) {
          double ratio = ((double) destWidth) / ((double) srcWidth);
          destHeight = (int) ((double) srcHeight * ratio);
        }
 
        // 硫붾え由ъ뿉 ���긽 �씠誘몄� �깮�꽦
        Image imgTarget = srcImg.getScaledInstance(destWidth, destHeight, Image.SCALE_SMOOTH);
        int pixels[] = new int[destWidth * destHeight];
        PixelGrabber pg = new PixelGrabber(imgTarget, 0, 0, destWidth,
            destHeight, pixels, 0, destWidth);
 
        pg.grabPixels();
 
        BufferedImage destImg = new BufferedImage(destWidth, destHeight,
            BufferedImage.TYPE_INT_RGB);
        destImg.setRGB(0, 0, destWidth, destHeight, pixels, 0, destWidth);
     
        // �뙆�씪�뿉 湲곕줉
        ImageIO.write(destImg, "jpg", dest);
        
        System.out.println(dest.getName() +  " �씠誘몄�瑜� �깮�꽦�뻽�뒿�땲�떎.");
      } catch (Exception e) {
        e.printStackTrace();
      }
      
      name = dest.getName(); // �깉濡� �깮�꽦�맂 �뙆�씪紐�
    } 
    
    return name;
  }
  
  /**
   * �씠誘몄� �궗�씠利덈�� 蹂�寃쏀븯�뿬 �깉濡쒖슫 Preview �씠誘몄�瑜� �깮�꽦�빀�땲�떎.
   * @param src �썝蹂� �씠誘몄�
   * @param dest �깮�꽦�릺�뒗 �씠誘몄�
   * @param width �깮�꽦�맆 �씠誘몄� �꼫鍮�
   * @param height �깮�꽦�맆 �씠誘몄� �넂�씠, ImageUtil.RATIO�뒗 �옄�룞 鍮꾨� 鍮꾩쑉
   * @throws IOException
   */
  public static synchronized String preview(String upDir, String _src, int width, int height) {
    int RATIO = 0;
    int SAME = -1;
    String preview_name = "";
    
    File src = new File(upDir + "/" + _src); // �썝蹂� �뙆�씪 媛앹껜 �깮�꽦
    String srcname = src.getName();         // �썝蹂� �뙆�씪紐� 異붿텧
    
    // �닚�닔 �뙆�씪紐� 異붿텧, mt.jpg -> mt 留� 異붿텧
    String _dest = srcname.substring(0, srcname.indexOf("."));
    
    // 異뺤냼 �씠誘몄� 議고빀 /upDir/mt_t.jpg
    File dest = new File(upDir + "/" + _dest + "_t.jpg"); 
    
    Image srcImg = null;
    // �뙆�씪�쓽 �솗�옣�옄 異붿텧
    String name = src.getName().toLowerCase(); // �뙆�씪紐� 異붿텧
    // �씠誘몄� �뙆�씪�씤吏� 寃��궗
    if (name.endsWith("jpg") || name.endsWith("bmp") || name.endsWith("png") || name.endsWith("gif")) {
      try {
        srcImg = ImageIO.read(src); // 硫붾え由ъ뿉 �썝蹂� �씠誘몄� �깮�꽦
        int srcWidth = srcImg.getWidth(null);   // �썝蹂� �씠誘몄� �꼫鍮� 異붿텧
        int srcHeight = srcImg.getHeight(null); // �썝蹂� �씠誘몄� �넂�씠 異붿텧
        int destWidth = -1, destHeight = -1;    // ���긽 �씠誘몄� �겕湲� 珥덇린�솕
        
        if (width == SAME) {    // width媛� 媛숈� 寃쎌슦
          destWidth = srcWidth;
        } else if (width > 0) {
          destWidth = width;    // �깉濡쒖슫 width瑜� �븷�떦
        }
        
        if (height == SAME) {    // �넂�씠媛� 媛숈� 寃쎌슦
          destHeight = srcHeight;
        } else if (height > 0) {
          destHeight = height;  // �깉濡쒖슫 �넂�씠濡� �븷�떦
        }
        
        // 鍮꾩쑉�뿉 �뵲瑜� �겕湲� 怨꾩궛
        if (width == RATIO && height == RATIO) {
          destWidth = srcWidth;
          destHeight = srcHeight;
        } else if (width == RATIO) {
          double ratio = ((double) destHeight) / ((double) srcHeight);
          destWidth = (int) ((double) srcWidth * ratio);
        } else if (height == RATIO) {
          double ratio = ((double) destWidth) / ((double) srcWidth);
          destHeight = (int) ((double) srcHeight * ratio);
        }
 
        // 硫붾え由ъ뿉 ���긽 �씠誘몄� �깮�꽦
        Image imgTarget = srcImg.getScaledInstance(destWidth, destHeight, Image.SCALE_SMOOTH);
        int pixels[] = new int[destWidth * destHeight];
        PixelGrabber pg = new PixelGrabber(imgTarget, 0, 0, destWidth,
            destHeight, pixels, 0, destWidth);
 
        pg.grabPixels();
 
        BufferedImage destImg = new BufferedImage(destWidth, destHeight,
            BufferedImage.TYPE_INT_RGB);
        destImg.setRGB(0, 0, destWidth, destHeight, pixels, 0, destWidth);
     
        // �뙆�씪�뿉 湲곕줉
        ImageIO.write(destImg, "jpg", dest);
        
        System.out.println(dest.getName() +  " �씠誘몄�瑜� �깮�꽦�뻽�뒿�땲�떎.");
      } catch (Exception e) {
        e.printStackTrace();
      }
      preview_name = dest.getName(); // �깉濡� �깮�꽦�맂 �뙆�씪紐�
    }else{
      preview_name = ""; // �씠誘몄� �뙆�씪�씠 �븘�땺寃쎌슦
    }
    
    return preview_name;
  }
 
  public static synchronized String youtube(String str, int width, int height){
    int index1 = str.indexOf("\"");   // 泥ル쾲吏� 臾몄옄 寃��깋
    int index2 = str.indexOf("\"", index1+1); // 泥ル쾲吏� �씠�썑遺��꽣 寃��깋
    int index3 = str.indexOf("\"", index2+1); // �몢踰덉㎏ �씠�썑遺��꽣 寃��깋
    int index4 = str.indexOf("\"", index3+1); // �꽭踰덉㎏ �씠�썑遺��꽣 寃��깋
    // System.out.println("--> index1: " + index1);
    // System.out.println("--> index2: " + index2);
    // System.out.println("--> index3: " + index3);
    // System.out.println("--> index4: " + index4);
 
    String str1 = str.substring(0, index1+1); // <iframe width='
    String str2 = str.substring(index2, index3+1); //  ' height='
    String str3 = str.substring(index4);   //  ' src=�씠�썑�쓽 紐⑤뱺 臾몄옄�뿴
    String url = str1 + width + "px" + str2 + height + "px" + str3;
 
    // System.out.println("--> str1: " + str1);
    // System.out.println("--> str1: " + str2);
    // System.out.println("--> str1: " + str3);
    return url;
  }
  
  /**  
   * �뙆�씪�쓣 �궘�젣�빀�땲�떎.  
  */ 
  public static synchronized boolean deleteFile(String folder, String fileName){ 
      boolean ret = false; 
       
      try{ 
          if ( fileName != null){ // 湲곗〈�뿉 �뙆�씪�씠 議댁옱�븯�뒗 寃쎌슦 �궘�젣 
              File file = new File(folder + "/" + fileName); 
              if (file.exists()){
                ret = file.delete();
              }
          } 
      }catch(Exception e){ 
          e.printStackTrace(); 
      } 
       
      return ret; 
  } 
 
  /**
   * �쉶�썝�쑝濡� 濡쒓렇�씤 �뻽�뒗吏� 寃��궗�빀�땲�떎.
   * @param request 
   * @return true: 濡쒓렇�씤 �쉶�썝, false: �넀�떂
   */
  public static synchronized  boolean isUser(HttpServletRequest request){
    boolean sw = false; // 濡쒓렇�씤 �뿬遺� ���옣
    
    // web �긽�쓽 session 媛앹껜 異붿텧
    HttpSession session = request.getSession();     
    String id = (String)session.getAttribute("id");
    
    if (id != null){
      sw = true;
    }else{
      sw = false;
    }
 
    return sw;
  }
 
  /**
   * �뤃�뜑瑜� �엯�젰諛쏆븘 �젅�� 寃쎈줈瑜� �궛異쒗빀�땲�떎. 
   * �삁) getRealPath(request, "/media/storage")
   * 
   * @param request
   * @param dir �젅�� 寃쎈줈瑜� 援ы븷 �뤃�뜑紐�
   * @return �젅�� 寃쎈줈 由ы꽩
   * @throws IOException
   */
  public static synchronized String getRealPath(HttpServletRequest request, String dir) {
    String path = "";
    
    try{
      path = request.getRealPath(dir) + "/";  
      // System.out.println("Upload path: " + path);
    }catch(Exception e){
      System.out.println(e.toString());
    }
 
    return path;
  }
 
  /**
   * �뙆�씪 �궘�젣
   * @param fname
   * @return
   */
  public static synchronized boolean deleteFile(String fname) {
    File file = new File(fname);
    boolean ret = false;
    
      if (file.exists()){
        ret = file.delete();
      }
    
    return ret;
  }
  
  /**
   * 臾몄옄�뿴�쓽 湲몄씠媛� length 蹂대떎 �겕硫� "..." �쓣 �몴�떆�븯�뒗 硫붿냼�뱶
   * 
   * @param length
   *          �꽑蹂꾪븷 臾몄옄�뿴 湲몄씠
   * @param str
   *          臾몄옄�뿴
   * @return
   */
  public static synchronized String textLength(int length, String str) {
 
    if (str != null) {
      if (str.length() > length) {
        str = str.substring(0, length) + "...";
      }
    } else {
      str = "";
    }
 
    return str;
  }
  
  /**
   * �젙�닔�삎 �뙆�씪 �겕湲곗뿉 �뜲�씠�꽣 �떒�쐞瑜� 異붽��빀�땲�떎.
   * @param length
   * @return
   */
  public static synchronized String unit(long length){
    String str = "";
 
    if (length < 1024){  // Byte: 0 ~ 1023
      str = length + " Byte";   
    }else if (length < (1024 * 1024)){ // Byte: 1024 ~ 1048575
      str = length / 1024 + " KB";
    }else if(length < (1024 * 1024 * 1024)){ // Byte: 1048576 ~ 1073741823
      str = length / 1024 / 1024 + " MB";
    }else if(length < (1024L * 1024 * 1024 * 1024)){ // Byte: 1073741824 ~
      str = length / 1024 / 1024 / 1024+ " GB";
    }
    
    return str;
  }
}