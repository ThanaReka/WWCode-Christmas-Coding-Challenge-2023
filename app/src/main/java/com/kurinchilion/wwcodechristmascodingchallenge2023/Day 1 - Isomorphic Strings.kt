package com.kurinchilion.wwcodechristmascodingchallenge2023
/*
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while
preserving the order of characters. No two characters may map to the same character,
but a character may map to itself.



Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true


Constraints:

1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character.

*/


class Solution {
    fun isIsomorphic(s: String, t: String): Boolean {

        if(s.length != t.length) return false

        val scharacters = s.toCharArray()
        val tcharacters = t.toCharArray()
        val map = mutableMapOf<Char, Char>()

        for(c in 0..scharacters.size -1){
            if(map.isEmpty()){
                map.put(scharacters[c], tcharacters[c])
            } else {
                if(map[scharacters[c]] != null){
                    val value = map[scharacters[c]]
                    if(value != tcharacters[c]){
                        return false
                    }
                } else {
                    if(map.containsValue(tcharacters[c])){
                        return false
                    }
                    map.put(scharacters[c], tcharacters[c])
                }
            }
        }
        return true
    }
}