package Stack;

import java.util.Stack;

public class SimplifyPath {
    public static String simplifyPath(String path) {
        String[] paths = path.split("/");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < paths.length; i++) {
            if (paths[i].equals("") || paths[i].equals(".")) {
                continue;
            }
            if (paths[i].equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(paths[i]);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append("/").append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/user/Pictures"));
    }
}
