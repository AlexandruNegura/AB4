package myApp.Reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Reader class with different functions
 *
 * Reads all types of data from specified constructor filename
 *
 * @author Alex
 */
public class Reader {
    BufferedReader br;
    StringTokenizer st;

    public Reader(String fileName) {
        try {
            br = new BufferedReader(new FileReader(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String nextString() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }


    public short nextShort() {
        return Short.parseShort(nextString());
    }

    public int nextInt() {
        return Integer.parseInt(nextString());
    }

    public long nextLong() {
        return Long.parseLong(nextString());
    }

    public double nextDouble() {
        return Double.parseDouble(nextString());
    }

    public float nextFloat() {
        return Float.parseFloat(nextString());
    }

    public String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}