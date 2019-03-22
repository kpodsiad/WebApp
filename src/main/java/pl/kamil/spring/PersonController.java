package pl.kamil.spring;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController
{
    private final PersonRepository personRepo;

    public PersonController(PersonRepository personRepo)
    {
        this.personRepo = personRepo;
    }

    @GetMapping("/person")
    public List<Person> getAll()
    {
        return personRepo.findAll();
    }

    @GetMapping("/person/{id}")
    public Optional<Person> getOne(@PathVariable Long id)
    {
        return personRepo.findById(id);
    }

    @PostMapping("/person")
    public Person add(@RequestBody Person person)
    {
        return personRepo.save(person);
    }

    @PutMapping("/person/{id}")
    public Person edit(@RequestBody Person newPerson, @PathVariable Long id)
    {
        return personRepo.findById(id)
                .map(person ->
                {
                    person.setFirstName(newPerson.getFirstName());
                    person.setLastName(newPerson.getLastName());
                    person.setGrossSalary(newPerson.getGrossSalary());
                    person.setJob(newPerson.getJob());
                    return personRepo.save(person);
                })
                .orElseGet(() ->
                {
                    newPerson.setId(id);
                    return personRepo.save(newPerson);
                });
    }

    @DeleteMapping("/person/{id}")
    public void delete(@PathVariable Long id)
    {
        personRepo.deleteById(id);
    }
}
