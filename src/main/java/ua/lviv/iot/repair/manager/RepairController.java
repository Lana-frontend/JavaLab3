package ua.lviv.iot.repair.manager;



import java.util.List;
import java.util.Optional;


import java.lang.Double;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javassist.NotFoundException;
import ua.lviv.iot.repair.model.Hammer;


@RestController
public class RepairController {

  @Autowired
  private RepairRepository equityRepository;

  @RequestMapping(value = "/equity", method = RequestMethod.GET)
  public List<Hammer> getEquities() {
    return (List<Hammer>) equityRepository.findAll();
  }

  @RequestMapping(value = "/equity/{id}", method = RequestMethod.GET)
  public Hammer getEquity(@PathVariable Integer id) {
    return equityRepository.findById(id).get();
  }

  @RequestMapping(value = "/equity", method = RequestMethod.POST)
  public Hammer postEquity(@RequestBody Hammer equity) {
    return equityRepository.save(equity);
  }

  @RequestMapping(value = "/equity/{id}", method = RequestMethod.PUT)
  public Hammer updateEquity(@RequestBody Hammer newEquity, @PathVariable Integer id) {
    return equityRepository.findById(id)
            .map(equity -> {
      newEquity.setId(id);
      return equityRepository.save(newEquity);
    }).orElseThrow(null);
  }

  @RequestMapping(value = "/equity/{id}", method = RequestMethod.DELETE)
  public Hammer deleteEquity(@PathVariable Integer id) {
    Hammer temp = getEquity(id);
    equityRepository.deleteById(id);
    return temp;
  }
}