package com.longnguyen.tikihometest.util

object StringUtil {
    fun handleKeywords(keyword: String): String {
        if (!keyword.contains(" ")) return keyword
        val centerPosition = (keyword.length - 1) / 2
        val charArr = keyword.toCharArray()
        for (i in centerPosition downTo 0) {
            if (charArr[keyword.length - i - 1] == ' ') {
                charArr[keyword.length - i - 1] = '\n'
                break
            }

            if (charArr[i] == ' ') {
                charArr[i] = '\n'
                break
            }

        }
        return String(charArr)
    }
}