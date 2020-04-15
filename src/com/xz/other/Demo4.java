package com.xz.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Package: com.xz.other
 * @ClassName: Demo4
 * @Author: xz
 * @Date: 2020/3/29 14:23
 * @Version: 1.0
 */
public class Demo4 {

    public static void main(String[] args) {
        System.out.println(maxLength(Arrays.asList("a", "abc", "d", "de", "def","hhh")));
    }

    public static int maxLength(List<String> arr) {
        List<String> ans = new ArrayList<>();
        dfs(arr, 0, arr.size(), "", ans);
        Collections.sort(ans, (a, b) -> -a.length() + b.length());
        int d = 0, i = 0, len = 0;
        for (String s : ans) {
            int[] a = new int[30];
            len = s.length();
            for (i = 0; i < len; i++)
                if (a[s.charAt(i) - 'a'] == 1) break;
                else a[s.charAt(i) - 'a'] = 1;
            if (i == len) {
                d = len;
                break;
            }
        }
        return d;
    }

    public static void dfs(List arr, int i, int n, String s, List ans) {
        if (i == n) {
            ans.add(s);
            return;
        }
        dfs(arr, i + 1, n, s, ans);
        dfs(arr, i + 1, n, s + arr.get(i), ans);
    }
}
