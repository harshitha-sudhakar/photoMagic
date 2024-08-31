import java.awt.Color;
public class PhotoMagic {
   
   public static Picture transform(Picture pic, LFSR lfsr) {
      for(int col = 0; col < pic.width(); col++) {
         for(int row = 0; row < pic.height(); row++) {
            Color color = pic.get(col, row);
            int r = color.getRed();
            int g = color.getGreen();
            int b = color.getBlue();
            
            int newR = r ^ lfsr.generate(8);
            int newG = g ^ lfsr.generate(8);
            int newB = b ^ lfsr.generate(8);
            
            Color newColor = new Color(newR, newG, newB);
            pic.set(col, row, newColor); 
          }
       }             
       
       return pic;
   }
   
   
   public static void main(String[] args) {
   
      Picture pic = new Picture("pipe.png");
      LFSR lfsr = new LFSR("01101000010100010000", 16);
      
      pic.show();
      Picture transformed = transform(pic, lfsr);
      transformed.show();
      Picture decrypted = transform(transformed, new LFSR("01101000010100010000", 16));
      decrypted.show();
   
   }
      




}