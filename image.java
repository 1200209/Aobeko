import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;


public class image {
	static int w;
	static int result;
	static BufferedImage read;
	static public void main(String[] args){ 
		File f = new File("test.jpg");
		try{
			read=ImageIO.read(f);
		}catch(Exception e){}
		w = read.getWidth();
		int h=read.getHeight();
		BufferedImage write = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

		int red_point = 0; 	//highest red value
		int nyanpas = 0;	//red value
		int point_x = 0;
		for(int x=0;x<w;x++){
			nyanpas = 0;
			for(int y=0;y<h;y++){
				int c = read.getRGB(x, y);
				int r = r(c);
				int g = g(c);
				int b = b(c);
				int rgb = rgb(r,g,b);
				int border = g + b;
				if(r > 140){
					if(border < 100){
						nyanpas++;
					}
				}
			}
			if(red_point < nyanpas){
				red_point = nyanpas;
				point_x = x;
			}
			result =  point_x;
		}
	//System.out.println(point_x+":"+red_point);
			System.out.println(result+" "+w);
	}

	static private int a(int c){
		return c>>>24;
	}

	static private int r(int c){
		return c>>16&0xff;
	}

	static private int g(int c){
		return c>>8&0xff;
	}

	static private int b(int c){
		return c&0xff;
	}
	static private int rgb
		(int r,int g,int b){
		return 0xff000000 | r <<16 | g <<8 | b;
	}

	static private int argb
		(int a,int r,int g,int b){
		return a<<24 | r <<16 | g <<8 | b;
	}

}

