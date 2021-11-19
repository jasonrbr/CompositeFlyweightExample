class EmployeeContext {
    String name
    String project
}

class Employee {
    long salary
    String title

    def getDescription(EmployeeContext c) {
        println("${c.name} is a ${this.title} who makes ${this.salary} working for ${c.project}")
    }
}

class EmployeeFactory {
    def static employeeMap = [:]

    def static CreateEmployee(String title) {
        if (this.employeeMap.containsKey(title)) {
            return this.employeeMap[title]
        }

        switch(title) {
            case 'Consultant':
                this.employeeMap[title] = new Employee(title: title, salary: 203000)
                break
            case 'SeniorConsultant':
                this.employeeMap[title] = new Employee(title: title, salary: 220000)
                break
            case 'AssociateDirector':
                this.employeeMap[title] = new Employee(title: title, salary: 250000)
                break
            case 'Director':
                this.employeeMap[title] = new Employee(title: title, salary: 300000)
                break
            case 'Principal':
                this.employeeMap[title] = new Employee(title: title, salary: 1000000)
                break
            default:
                throw new RuntimeException("No matching class for title: ${title}")
        }

        this.employeeMap[title]
    }
}

def director = EmployeeFactory.CreateEmployee('Director')
def dariusContext = new EmployeeContext(name: 'Darius', project: 'Cool Modernizing Insurance')
def mattContext = new EmployeeContext(name: 'Matt', project: 'Very Awesome Data Modernizing')
def priContext = new EmployeeContext(name: 'Pri', project: 'Silly Canadian Insurance')
def jeffContext = new EmployeeContext(name: 'Jeff', project: 'Boring Healthcare Project')

director.getDescription(dariusContext)
director.getDescription(jeffContext)