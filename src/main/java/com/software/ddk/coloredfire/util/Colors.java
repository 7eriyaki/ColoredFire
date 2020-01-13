package com.software.ddk.coloredfire.util;

public class Colors {

    public static int getIntColor(float red, float green, float blue){
        int r = Math.round(255 * red);
        int g = Math.round(255 * green);
        int b = Math.round(255 * blue);
        r = (r << 16) & 0x00ff0000;
        g = (g << 8) & 0x0000ff00;
        b = b & 0x000000ff;
        return 0xFF000000 | r | g | b;
    }

    public static int getIntColor(int red, int green, int blue){
        red = (red << 16) & 0x00ff0000;
        green = (green << 8) & 0x0000ff00;
        blue = blue & 0x000000ff;
        //int tst = 0xFF000000 | red | green | blue;
        //System.out.println("color: " + tst);
        return 0xFF000000|red|green|blue;
    }

    public static float[] getRGBColor(int color){
        float r = ((color >> 16) & 255) / 255.0F;
        float g = ((color >> 8) & 255) / 255.0F;
        float b = ((color & 255)) / 255.0F;
        return new float[]{r, g, b};
    }

    public static int[] getRGBColorInt(int color) {
        int r = (color >> 16) & 0xFF;
        int g = (color >> 8) & 0xFF;
        int b = (color) & 0xFF;
        return new int[]{r, g, b};
    }

    public static int colorLighter(int color, float fraction){
        int[] cbr = brightColor(color, fraction);
        return getIntColor(cbr[0], cbr[1], cbr[2]);
    }

    public static int[] brightColor(int color, float fraction) {
        int[] col = getRGBColorInt(color);
        int i = (int) (1.0 / (1.0 - fraction));
        if (col[0] == 0 && col[1] == 0 && col[2] == 0) {return new int[]{i, i, i};}
        for (int c=0; c < col.length; c++){
            if (col[c] > 0 && col[c] < i) col[c] = i;
        }
        return new int[]{Math.min((int)(col[0] / fraction), 255), Math.min((int)(col[1] / fraction), 255), Math.min((int)(col[2] / fraction), 255)};
    }

}
