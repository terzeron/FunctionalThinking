class Employee {
    def name, salary
}

def paidMore(amount) {
    return { Employee e -> e.salary > amount }
}

isHighPaid = paidMore(100000)

def Smithers = new Employee(name: "Fred", salary: 120000)
def Homer = new Employee(name: "Homer", salary: 80000)
println isHighPaid(Smithers)
println isHighPaid(Homer)

isHigherPaid = paidMore(200000)
println isHigherPaid(Smithers)
println isHigherPaid(Homer)

def Burns = new Employee(name: "Monty", salary: 1000000)
println isHigherPaid(Burns)
