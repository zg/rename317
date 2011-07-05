package rs2;


public class Graphics2D extends NodeSub {

	public static void setTarget(int height, int width, int pixels[]) {
		Graphics2D.pixels = pixels;
		Graphics2D.width = width;
		Graphics2D.height = height;
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

	public static void setBounds(int height, int topX, int width, int topY) {
		if (topX < 0) {
			topX = 0;
		}
		if (topY < 0) {
			topY = 0;
		}
		if (width > Graphics2D.width) {
			width = Graphics2D.width;
		}
		if (height > Graphics2D.height) {
			height = Graphics2D.height;
		}
		Graphics2D.topX = topX;
		Graphics2D.topY = topY;
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
		int line_offset = Graphics2D.width - width;
		int ptr = x + y * Graphics2D.width;
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
		int line_offset = Graphics2D.width - width;
		int ptr = x + y * Graphics2D.width;
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
		int ptr = x + y * Graphics2D.width;
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


	Graphics2D() {
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
