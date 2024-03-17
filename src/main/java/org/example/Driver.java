package org.example;

public class Driver {
    public static void main(String[] args) {
        Router router = new RouterImpl();

        router.withRoute("/bar", "result");
        System.out.println(router.route("/bar")); // -> "result"

        router.withRoute("/bar/abc", "abc");
        System.out.println(router.route("/bar/abc"));// -> "abc"
        System.out.println(router.route("/bar/abc/dd")); //-> null

        router.withRoute("/bar/abc/dd", "dd");
        router.withRoute("/bar/abc1/cde/dd", "ee");
        System.out.println(router.route("/bar/*/dd"));// -> "dd"
        System.out.println(router.route("/bar/*/cde/dd")); // -> "ee"
    }
}
