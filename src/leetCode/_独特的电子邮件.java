package leetCode;

import java.util.HashSet;
import java.util.Set;

public class _独特的电子邮件 {
    public static void main(String[] args) {
        String []emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(emails));
    }

    /**
     * 模拟题，首先根据题意模拟内容，其次利用Set集合去重
     *
     * @param emails
     * @return
     */
    public static int numUniqueEmails(String[] emails) {
        Set<String> ans = new HashSet<String>();
        for (int i = 0; i < emails.length; i++) {
            String str = emails[i];
            String tail = str.substring(str.lastIndexOf('@'));
            char[] arr = str.toCharArray();
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < arr.length && arr[j] != '@'; j++) {
                if (arr[j] == '.') continue;
                if (arr[j] == '+') break;
                sb.append(arr[j]);
            }
            ans.add(sb.toString() + tail);
        }
        return ans.size();
    }

}
