def product = { x, y -> x * y }
def quadrate = product.curry(4)
def octate = product.curry(8)

println "4x3: ${quadrate.call(3)}"
println "8x5: ${octate.call(5)}"