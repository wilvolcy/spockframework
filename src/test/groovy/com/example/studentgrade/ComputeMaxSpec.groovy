package com.example.studentgrade

import spock.lang.Specification
import spock.lang.Unroll

class ComputeMaxSpec extends Specification{
    @Unroll ("The maximum of #a and #b is #c")
    def 'Compute maximum of two number '(){
        expect :
            Math.max(a ,b) == c
        where :
            a << [1, 3]
            b << [3, 4]
            c << [3, 4]
    }
    @Unroll
    def 'compute maximum of 2 number using table'(){
        expect :
            Math.max(num1,num2) == maxValue
        where :
        maxValue | num1 | num2
        5        | 3    |5
        9        | 6    |9
    }
    def "Test with stack "(){
        given :
            def stackElement = new Stack()
            def element = 'push me to the stack'
        when :
            stackElement.push(element)
        then :
            stackElement.size() == 1
            !stackElement.empty()
            stackElement.pop() == element
        when :
            stackElement.pop()
        then :
            thrown(EmptyStackException)
            stackElement.empty()
        when :
            stackElement.pop()
        then :
            EmptyStackException e = thrown()
            e.cause == null

    }
    def 'check notThrown exception for HasMap' () {
        given :
            def mapValue = new HashMap<String,String>()
        when :
            mapValue.put(null,"anything")
        then:
        notThrown(NullPointerException)
    }
   def 'Check old at listing' (){
       given :
            def values = ['3','2','6']
       when :
            values << 9
       then :
            values.size() == 4
            old(values.size()) == 3
   }
   def 'Check old value with map' (){
       given :
            def map = [:]
            map.example = 'some value'
       when :
            map.example = 'change value'
       then :
            map.example == 'change value'
            old(map.example) == 'some value'
            old(map.example) != map.example
   }
}
