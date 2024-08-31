public class PhotoMagicDeluxe {
   
   
   public static Picture transform(Picture pic, String pw, int tap) {      
      String base64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
      String seed = "";
      for(int i = 0; i < pw.length(); i++) {
         int num = base64.indexOf(pw.substring(i, i + 1));
         String binary = String.format("%6s", Integer.toBinaryString(num)).replace(" ", "0");
         seed+= binary;
      }
      
      return PhotoMagic.transform(pic, new LFSR(seed, tap));
   }

   public static void main(String[] args) {
   
      Picture pic = new Picture("mystery.png");
      pic.show();
      Picture decrypted = transform(pic, "OPENSESAME", 58);      
      decrypted.show();
      
      Picture pic2 = new Picture("mystery2.png");
      pic2.show();
      Picture decrypted2 = transform(pic2, "GOKNIGHTS", 50);      
      decrypted2.show();
   
   }

}