package _笔试;

/**
 * 力扣高校测试水题，但该题存在坑点，数字旋转的时候，是整体旋转，而不是单个旋转
 */
public class _易混淆数 {
    public static void main(String[] args) {
        System.out.println(confusingNumber(89));
    }
    public static boolean confusingNumber(int N) {
        String src = N+"";
        char[]a = src.toCharArray();
        String t =  "";
        for(int i = a.length-1;i>=0;i--){
            if(a[i]=='2'||a[i]=='3' || a[i]=='4'|| a[i]=='5' || a[i]=='7'){
                return false;
            }else if(a[i]=='6'){
                t+=9;
            }else if(a[i]=='9'){
                t+=6;
            }else{
                t+=a[i];
            }
        }
        return N!=Integer.parseInt(t);
    }
}
