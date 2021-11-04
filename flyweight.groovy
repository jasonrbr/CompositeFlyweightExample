class EmployeeContext {
    String name
    String project
}

class Employee {

    Employee(long aSalary) {
        this.salary = aSalary
    }

    long salary

    def long getSalary() {
        salary
    }

    def getDescription(EmployeeContext c) {
        println("${c.name} makes ${this.getSalary()} working for ${c.project}")
    }
}

class EmployeeFactory {
    def static employeeMap = [:]

    def static getEmployee(String type) {
        if (this.employeeMap.containsKey(type)) {
            return this.employeeMap[type]
        }

        switch(type) {
            case 'Consultant':
                this.employeeMap[type] = new Employee(203000)
                break
            case 'SeniorConsultant':
                this.employeeMap[type] = new Employee(220000)
                break
            case 'AssociateDirector':
                this.employeeMap[type] = new Employee(250000)
                break
            case 'Director':
                this.employeeMap[type] = new Employee(300000)
                break
            case 'Principal':
                this.employeeMap[type] = new Employee(1000000)
                break
            default:
                throw new RuntimeException("No matching class for type: ${type}")
        }

        this.employeeMap[type]
    }
}

def director = EmployeeFactory.getEmployee('Director')
def dariusContext = new EmployeeContext(name: 'Darius', project: 'Cool Modernizing Insurance')
def mattContext = new EmployeeContext(name: 'Matt', project: 'Very Awesome Data Modernizing')
def priContext = new EmployeeContext(name: 'Pri', project: 'Silly Canadian Insurance')
def jeffContext = new EmployeeContext(name: 'Jeff', project: 'Boring Healthcare Project')

director.getDescription(dariusContext)
director.getDescription(jeffContext)