package leetcode;

public class Problem8 {
    public int myAtoi(String str) {
        int result = 0;
        char[] chars = str.toCharArray();
        boolean started = false;
        boolean negative = false;
        byte digits = 0;
        for (char c : chars) {
            //' '
            if (c == 32) {
                if (started) {
                    return negative ? -result : result;
                } else {
                    continue;
                }
            }
            //'+'
            if (c == 43) {
                if (started) {
                    return negative ? -result : result;
                } else {
                    started = true;
                    continue;
                }
            }
            //'-'
            if (c == 45) {
                if (started) {
                    return negative ? -result : result;
                } else {
                    started = true;
                    negative = true;
                    continue;
                }
            }
            //digits
            if (c >= 48 && c <= 57) {
                if (c == 48 && result == 0) {
                    started = true;
                    continue;
                } else {
                    started = true;
                    int current = c - 48;
                    if (digits == 10) {
                        return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                    } else if (digits == 9) {
                        int cap = 214748364;
                        if (!negative) {
                            if (result > cap) {
                                return Integer.MAX_VALUE;
                            } else if (result == cap) {
                                if (current >= 7) {
                                    return Integer.MAX_VALUE;
                                } else {
                                    result = result * 10 + current;
                                    digits++;
                                    continue;
                                }
                            } else {
                                result = result * 10 + current;
                                digits++;
                                continue;
                            }
                        } else {
                            if (result > cap) {
                                return Integer.MIN_VALUE;
                            } else if (result == cap) {
                                if (current >= 8) {
                                    return Integer.MIN_VALUE;
                                } else {
                                    result = result * 10 + current;
                                    digits++;
                                    continue;
                                }
                            } else {
                                result = result * 10 + current;
                                digits++;
                                continue;
                            }
                        }
                    } else {
                        result = result * 10 + current;
                        digits++;
                        continue;
                    }
                }
            }
            return negative ? -result : result;
        }
        return negative ? -result : result;
    }
}
