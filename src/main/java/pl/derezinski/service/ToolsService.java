package pl.derezinski.service;

import pl.derezinski.dao.ToolDao;
import pl.derezinski.dao.ToolDaoImp;
import pl.derezinski.model.Tool;

import java.util.List;
import java.util.Optional;

public class ToolsService {

    private ToolDao toolDao = new ToolDaoImp();

    public List<Tool> getTools() {
        return toolDao.getAllTools();
    }

//    public ToolsService() {
//        tools = new ArrayList<>();
//
//        tools.add(new Tool(1L, "Czerwony młotek" , ToolType.HAMMER, true));
//        tools.add(new Tool(2L, "Niebieski młotek", ToolType.HAMMER, true));
//        tools.add(new Tool(3L, "Nowa piła", ToolType.SAW, true));
//        tools.add(new Tool(4L, "Śrubokręt klasyczny", ToolType.SCREWDRIVER, false));
//        tools.add(new Tool(5L, "Śrubokręt soniczny", ToolType.SCREWDRIVER, true));
//        tools.add(new Tool(6L, "Zardzewiała piła", ToolType.SAW, true));
//        tools.add(new Tool(7L, "Normal pipette", ToolType.PIPETTE, true));
//        tools.add(new Tool(8L, "Multichannel pipette", ToolType.PIPETTE, true));
//        tools.add(new Tool(9L, "Repeater pipette", ToolType.PIPETTE, false));
//        tools.add(new Tool(10L, "Porcelanowy młotek", ToolType.HAMMER, true));
//    }
//
//    public List<Tool> getTools(){
//        return tools;
//    }

    public Optional<Tool> getTool(Long id){
        return toolDao.getAllTools().stream().filter(tool -> tool.getId().equals(id)).findAny();
    }

    public List<Tool> takeTool(Long id){
        return setAvailability(id, false);
    }

    public List<Tool> returnTool(Long id){
        return setAvailability(id, true);
    }

    private List<Tool> setAvailability(Long id, boolean isAvailable){
        toolDao.setAvailability(id, isAvailable);
        return getTools();
    }
}
