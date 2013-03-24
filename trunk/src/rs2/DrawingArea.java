package rs2;


import rs2.util.collection.QueueNode;

public class DrawingArea extends QueueNode {

	public static void setTarget(int height, int width, int pixels[]) {
		DrawingArea.pixels = pixels;
		DrawingArea.width = width;
		DrawingArea.height = height;
		setBounds(height, 0, width, 0);
	}

	public static void setDefaultBounds() {
		topX = 0;
		topY = 0;
		viewport_w = width;
		viewport_h = height;
		viewportRx = viewport_w;
		viewportCx = viewport_w / 2;
	}
	
	static final void blockImageTransfer(int i, int i_46_, int i_47_, int i_48_, int[] spritePixels) {
		  int i_49_ = i_47_ * i_47_;
		  int x = i - i_47_ >> 4;
		  int width = i + i_47_ + 15 >> 4;
		  int y = i_46_ - i_47_ >> 4;
		  int height = i_46_ + i_47_ + 15 >> 4;
		  if (x < topX)
		      x = topX;
		  if (width > viewport_w)
		      width = viewport_w;
		  if (y < topY)
		      y = topY;
		  if (height > viewport_h)
		      height = viewport_h;
		  int i_54_ = (x << 4) - i;
		  i_54_ *= i_54_;
		  int i_55_ = (x + 1 << 4) - i;
		  i_55_ *= i_55_;
		  int i_56_ = (x + 2 << 4) - i;
		  i_56_ *= i_56_;
		  int i_57_ = i_55_ - i_54_;
		  int i_58_ = i_56_ - i_55_;
		  int i_59_ = i_58_ - i_57_;
		  int i_60_ = (y << 4) - i_46_;
		  i_60_ *= i_60_;
		  int i_61_ = (y + 1 << 4) - i_46_;
		  i_61_ *= i_61_;
		  int i_62_ = (y + 2 << 4) - i_46_;
		  i_62_ *= i_62_;
		  int i_63_ = i_61_ - i_60_;
		  int i_64_ = i_62_ - i_61_;
		  int i_65_ = i_64_ - i_63_;
		  int ptr = x + y * DrawingArea.width;
		  int i_67_ = DrawingArea.width + x - width;
		  a(i_59_, i_49_, ptr, pixels, i_48_, spritePixels, i_67_, i_57_, x - width, i_60_ + i_54_,
		    i_63_, i_65_, y - height);
		    }
		    
		    private static final void a
		  (int i_72_, int i_73_, int i_74_, int[] is, int i_75_, int[] is_76_,
		   int i_77_, int i_78_, int i_79_, int i_80_, int i_81_, int i_82_,
		   int i_83_) {
		  for (/**/; i_83_ < 0; i_83_++) {
		      int i_70_ = i_80_;
		      int i_71_ = i_78_;
		      for (int i_84_ = i_79_; i_84_ < 0; i_84_++) {
		    if (i_70_ < i_73_) {
		        int i = is_76_[(i_73_ - i_70_) * i_75_ / i_73_];
		        int i_68_ = is[i_74_];
		        int i_69_ = i + i_68_;
		        i = (i & 0xff00ff) + (i_68_ & 0xff00ff);
		        i_68_ = (i & 0x1000100) + (i_69_ - i & 0x10000);
		        is[i_74_] = i_69_ - i_68_ | i_68_ - (i_68_ >>> 8);
		    }
		    i_74_++;
		    i_70_ += i_71_;
		    i_71_ += i_72_;
		      }
		      i_74_ += i_77_;
		      i_80_ += i_81_;
		      i_81_ += i_82_;
		  }
		    }

	
    static final void drawDiagionalLine(int x, int y, int width, int height, int colour) {
    	width -= x;
    	height -= y;
    	if (height == 0) {
    	    if (width >= 0)
    		drawHLine(x, y, width + 1, colour);
    	    else
    		drawHLine(x + width, y, -width + 1, colour);
    	} else if (width == 0) {
    	    if (height >= 0)
    		drawVLine(x, y, height + 1, colour);
    	    else
    		drawVLine(x, y + height, -height + 1, colour);
    	} else {
    	    if (width + height < 0) {
    		x += width;
    		width = -width;
    		y += height;
    		height = -height;
    	    }
    	    if (width > height) {
    		y <<= 16;
    		y += 32768;
    		height <<= 16;
    		int i_38_ = (int) Math.floor((double) height / (double) width + 0.5);
    		width += x;
    		if (x < topX) {
    		    y += i_38_ * (topX - x);
    		    x = topX;
    		}
    		if (width >= viewport_w)
    		    width = viewport_w - 1;
    		for (/**/; x <= width; x++) {
    		    int i_39_ = y >> 16;
    		    if (i_39_ >= topY && i_39_ < viewport_h)
    			pixels[x + i_39_ * DrawingArea.width] = colour;
    		    y += i_38_;
    		}
    	    } else {
    		x <<= 16;
    		x += 32768;
    		width <<= 16;
    		int i_40_ = (int) Math.floor((double) width / (double) height + 0.5);
    		height += y;
    		if (y < topY) {
    		    x += i_40_ * (topY - y);
    		    y = topY;
    		}
    		if (height >= viewport_h)
    		    height = viewport_h - 1;
    		for (/**/; y <= height; y++) {
    		    int i_41_ = x >> 16;
    		    if (i_41_ >= topX && i_41_ < viewport_w)
    			pixels[i_41_ + y * DrawingArea.width] = colour;
    		    x += i_40_;
    		}
    	    }
    	}
        }
    
	public static void setBounds(int height, int topX, int width, int topY) {
		if (topX < 0) {
			topX = 0;
		}
		if (topY < 0) {
			topY = 0;
		}
		if (width > DrawingArea.width) {
			width = DrawingArea.width;
		}
		if (height > DrawingArea.height) {
			height = DrawingArea.height;
		}
		DrawingArea.topX = topX;
		DrawingArea.topY = topY;
		viewport_w = width;
		viewport_h = height;
		viewportRx = viewport_w;
		viewportCx = viewport_w / 2;
		viewportCy = viewport_h / 2;
	}

	public static void resetImage() {
		int image = width * height;
		for (int i = 0; i < image; i++) {
			pixels[i] = 0;
		}

	}

	public static void fillRect(int x, int y, int width, int height, int colour, int alpha) {
		if (x < topX) {
			width -= topX - x;
			x = topX;
		}
		if (y < topY) {
			height -= topY - y;
			y = topY;
		}
		if (x + width > viewport_w) {
			width = viewport_w - x;
		}
		if (y + height > viewport_h) {
			height = viewport_h - y;
		}
		int dest_intensity = 256 - alpha;
		int src_red = (colour >> 16 & 0xff) * alpha;
		int src_green = (colour >> 8 & 0xff) * alpha;
		int src_blue = (colour & 0xff) * alpha;
		int line_offset = DrawingArea.width - width;
		int ptr = x + y * DrawingArea.width;
		for (int y_off = 0; y_off < height; y_off++) {
			for (int x_off = -width; x_off < 0; x_off++) {
				int dest_red = (pixels[ptr] >> 16 & 0xff) * dest_intensity;
				int dest_green = (pixels[ptr] >> 8 & 0xff) * dest_intensity;
				int dest_blue = (pixels[ptr] & 0xff) * dest_intensity;
				int result_rgb = ((src_red + dest_red >> 8) << 16) + ((src_green + dest_green >> 8) << 8) + (src_blue + dest_blue >> 8);
				pixels[ptr++] = result_rgb;
			}

			ptr += line_offset;
		}
	}

	public static void fillRect(int x, int y, int width, int height, int colour) {
		if (x < topX) {
			width -= topX - x;
			x = topX;
		}
		if (y < topY) {
			height -= topY - y;
			y = topY;
		}
		if (x + width > viewport_w) {
			width = viewport_w - x;
		}
		if (y + height > viewport_h) {
			height = viewport_h - y;
		}
		int line_offset = DrawingArea.width - width;
		int ptr = x + y * DrawingArea.width;
		for (int y_off = -height; y_off < 0; y_off++) {
			for (int x_off = -width; x_off < 0; x_off++) {
				pixels[ptr++] = colour;
			}

			ptr += line_offset;
		}

	}

	public static void drawRect(int x, int y, int width, int height, int colour) {
		drawHLine(x, y, width, colour);
		drawHLine(x, (y + height) - 1, width, colour);
		drawVLine(x, y, height, colour);
		drawVLine((x + width) - 1, y, height, colour);
	}

	public static void drawRect(int x, int y, int width, int height, int colour, int alpha) {
		drawHLine(x, y, width, colour, alpha);
		drawHLine(x, (y + height) - 1, width, colour, alpha);
		if (height >= 3) {
			drawVLine(x, y + 1, height - 2, colour, alpha);
			drawVLine((x + width) - 1, y + 1, height - 2, colour, alpha);
		}
	}

	public static void drawHLine(int x, int y, int width, int colour) {
		if (y < topY || y >= viewport_h) {
			return;
		}
		if (x < topX) {
			width -= topX - x;
			x = topX;
		}
		if (x + width > viewport_w) {
			width = viewport_w - x;
		}
		int ptr = x + y * DrawingArea.width;
		for (int x_off = 0; x_off < width; x_off++) {
			pixels[ptr + x_off] = colour;
		}

	}

	public static void drawHLine(int x, int y, int height, int colour, int alpha) {
		if (y < topY || y >= viewport_h) {
			return;
		}
		if (x < topX) {
			height -= topX - x;
			x = topX;
		}
		if (x + height > viewport_w) {
			height = viewport_w - x;
		}
		int dest_intensity = 256 - alpha;
		int src_red = (colour >> 16 & 0xff) * alpha;
		int src_green = (colour >> 8 & 0xff) * alpha;
		int src_blue = (colour & 0xff) * alpha;
		int ptr = x + y * width;
		for (int off_y = 0; off_y < height; off_y++) {
			int dest_red = (pixels[ptr] >> 16 & 0xff) * dest_intensity;
			int dest_green = (pixels[ptr] >> 8 & 0xff) * dest_intensity;
			int dest_blue = (pixels[ptr] & 0xff) * dest_intensity;
			int result_rgb = ((src_red + dest_red >> 8) << 16) + ((src_green + dest_green >> 8) << 8) + (src_blue + dest_blue >> 8);
			pixels[ptr++] = result_rgb;
		}

	}

	public static void drawVLine(int x, int y, int height, int colour) {
		if (x < topX || x >= viewport_w) {
			return;
		}
		if (y < topY) {
			height -= topY - y;
			y = topY;
		}
		if (y + height > viewport_h) {
			height = viewport_h - y;
		}
		int ptr = x + y * width;
		for (int y_off = 0; y_off < height; y_off++) {
			pixels[ptr + y_off * width] = colour;
		}

	}

	public static void drawVLine(int x, int y, int height, int colour, int alpha) {
		if (x < topX || x >= viewport_w) {
			return;
		}
		if (y < topY) {
			height -= topY - y;
			y = topY;
		}
		if (y + height > viewport_h) {
			height = viewport_h - y;
		}
		int dest_intensity = 256 - alpha;
		int src_red = (colour >> 16 & 0xff) * alpha;
		int src_green = (colour >> 8 & 0xff) * alpha;
		int src_blue = (colour & 0xff) * alpha;
		int ptr = x + y * width;
		for (int y_off = 0; y_off < height; y_off++) {
			int dest_red = (pixels[ptr] >> 16 & 0xff) * dest_intensity;
			int dest_green = (pixels[ptr] >> 8 & 0xff) * dest_intensity;
			int dest_blue = (pixels[ptr] & 0xff) * dest_intensity;
			int result_rgb = ((src_red + dest_red >> 8) << 16) + ((src_green + dest_green >> 8) << 8) + (src_blue + dest_blue >> 8);
			pixels[ptr] = result_rgb;
			ptr += width;
		}

	}
	

	public static void fillCircleAlpha(int posX, int posY, int radius, int colour, int alpha)//draw circle? - used for highlighting the map symbols ;D
	{
		/*
		 * looks like they used this as there base model
		 * for(float i = -RADIUS; i < RADIUS; i +=RADIUS/NUM_LINES)
		 *	{
		 *	ycoord = i;
		 *	xcoord1 = sqrt(RADIUS^2 - i^2);
		 *	xcoord2 = -xcoord1;
		 * }
		 */
		int dest_intensity = 256 - alpha;
		int src_red = (colour >> 16 & 0xff) * alpha;
		int src_green = (colour >> 8 & 0xff) * alpha;
		int src_blue = (colour & 0xff) * alpha;
		int i3 = posY - radius;
		if(i3 < 0)
			i3 = 0;
		int j3 = posY + radius;
		if(j3 >= height)
			j3 = height - 1;
		for(int y = i3; y <= j3; y++)
		{
			int l3 = y - posY;
			int i4 = (int)Math.sqrt(radius * radius - l3 * l3);
			int x = posX - i4;
			if(x < 0)
				x = 0;
			int k4 = posX + i4;
			if(k4 >= width)
				k4 = width - 1;
			int pixel_offset = x + y * width;
			for(int i5 = x; i5 <= k4; i5++)
			{
				int dest_red = (pixels[pixel_offset] >> 16 & 0xff) * dest_intensity;
				int dest_green = (pixels[pixel_offset] >> 8 & 0xff) * dest_intensity;
				int dest_blue = (pixels[pixel_offset] & 0xff) * dest_intensity;
				int result_rgb = ((src_red + dest_red >> 8) << 16) + ((src_green + dest_green >> 8) << 8) + (src_blue + dest_blue >> 8);
				pixels[pixel_offset++] = result_rgb;
			}

		}

	}
	public static void fillCircle(int posX, int posY, int radius, int colour)
	{
		int i3 = posY - radius;
		if(i3 < 0)
			i3 = 0;
		int j3 = posY + radius;
		if(j3 >= height)
			j3 = height - 1;
		for(int y = i3; y <= j3; y++)
		{
			int l3 = y - posY;
			int i4 = (int)Math.sqrt(radius * radius - l3 * l3);
			int x = posX - i4;
			if(x < 0)
				x = 0;
			int k4 = posX + i4;
			if(k4 >= width)
				k4 = width - 1;
			int pixel_offset = x + y * width;
			for(int i5 = x; i5 <= k4; i5++)
			{

				pixels[pixel_offset++] = colour;
			}

		}

	}


	DrawingArea() {
	}

	public static int pixels[];
	public static int width;
	public static int height;
	public static int topY;
	public static int viewport_h;
	public static int topX;
	public static int viewport_w;
	public static int viewportRx;
	public static int viewportCx;
	public static int viewportCy;

}
