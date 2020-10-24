package com.example.studentgrade

import spock.lang.Specification

class ComputeMaxSpec extends Specification{
    def 'Compute maximum of two number '(){
        expect :
            Math.max(a ,b) == c
        where :
            a << [1, 3]
            b << [3, 4]
            c << [3, 4]

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
}
