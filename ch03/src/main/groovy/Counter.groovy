def Closure makeCounter() {
    def local_variable = 0
    return { return local_variable += 1 }
}

c1 = makeCounter()
c1()
c1()
c1()

c2 = makeCounter()
c2()
c2()

println "C1 = ${c1()}, C2 = ${c2()}"