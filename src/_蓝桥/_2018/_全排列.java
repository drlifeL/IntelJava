package _蓝桥._2018;

public class _全排列 {

    static void permu(char[] data, int cur) {
        if (cur == data.length - 1) {
            System.out.println(new String(data));
            return;
        }

        for (int i = cur; i < data.length; i++) {
            char tmp = data[i];
            for (int j = i - 1; j >= cur; j--)
                data[j + 1] = data[j];
            data[cur] = tmp;

            permu(data, cur + 1);

            tmp = data[cur];
//            __________________________________________;
            for (int j = i; j > cur ; j--)
                data[j-1] =data[j];

            data[i] = tmp;

        }
    }

    static void permu(String x) {
        permu(x.toCharArray(), 0);
    }

    public static void main(String[] args) {
        permu("1234");
    }
}
