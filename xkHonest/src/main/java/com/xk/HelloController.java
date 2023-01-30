package com.xk;

import com.xk.common.util.NotFoundException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

/**
 * Created by yuan on 2022/04/21
 */
@Controller
public class HelloController {

    @GetMapping("/start")
    public String index() {
        return "index";
    }

    // http://127.0.0.1:8080/xxx
    @GetMapping("/404")
    public String index404() {
        String blog = null;
        if (blog == null) {
            throw new NotFoundException("博客不存在");
        }
        return "index";
    }

    // http://127.0.0.1:8080/500
    @GetMapping("/500")
    public String index500() {
        int i = 9 / 0;
        return "index";
    }

    // http://127.0.0.1:8080
//    @GetMapping("/{id}/{name}")
//    public String indexA(@PathVariable Integer id, @PathVariable String name) {
//        System.out.println("------ indexA ------");
//        return "index";
//    }

    /* 方法注解 */
    @ApiOperation(value = "desc of method", notes = "")
    @GetMapping(value = "/hello")
    @Operation(summary = "商品详情,针对得到单个商品的信息")
    public Object hello( /* 参数注解 */ @ApiParam(value = "desc of param", required = true) @RequestParam String name) {
        return "Hello " + name + "!";
    }



    public static void main (String args[]) {
//        test2(null);
//        test4(null);
//        System.out.println((int) 5/2);
//        int[] input = {1,2,3,4,5};
//        dothings(input);

    }

    public static void dothings (int[] param) {
        int[] result = new int[param.length];
        Arrays.sort(param);

        if (param.length%2 == 1) {
            int i = param.length;
            int index = param.length/2;
            while(i>0) {
                if (param.length == i) {
                    index = index;
                } else if (i%2 == 0) {
                    index = index%2 == 0 ? index/2 : index/2-1; // +1, -1
                } else if (i%2 == 1) {
                    index = index%2 == 0 ? param.length-1 : i; // +1, -1
                }
                result[index] = param[i-1];
                i--;
            }
        }
        if (param.length%2 == 0) {
            for (int i=param.length; i <= 0 ; i--) {
                int index = param.length/2;
                if (param.length == i) {

                } else if (param.length%2 == 0) {
                    index = i-index-1; // +1, -1
                } else if (param.length%2 == 1) {
                    index = i-index+1; // +1, -1
                }
                result[index+1] = param[i-1];
            }
        }

        for (int i : result) {
            System.out.println(result[i]);
        }
    }

    public static void test4 (String args[]) {
        Boolean result = false;
        String s = "abcde";
        String goal = "cdeab";

        int countTrue = 0;
        for (int i=0; i<s.length(); i++) {
            for(int j=0; j<goal.length(); i++) {
                if((String.valueOf(s.charAt(i))).equals(String.valueOf(goal.charAt(j)))) {
                    countTrue++;
                }
            }
        }
        if(countTrue == s.length()) {
            result = true;
        }
        System.out.println(result);
    }
    public static void test2 (String args[]) {
        int input = 19;
        int result = 0;

        if(check(input)) {
            result = loop(input);
        }

        if(result == 1) {
            System.out.println("Happy Number");
        }
        System.out.println("not Happy Number");
    }

    public static Boolean check(int input) {
        if(input > 1) {
            return true;
        }
        return false;
    }

    public static Integer loop(int input) {
        String str = String.valueOf(input);
        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
            int singleNum = str.charAt(i);
            sum += singleNum * singleNum;
        }

        if(check(sum)) {
            loop(sum);
        }

        return sum;
    }

}