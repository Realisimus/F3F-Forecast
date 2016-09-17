package weather.dbinterfaces.mysql;

import weather.WindTable;
import weather.dbinterfaces.DataObject;

public class sqlConnector implements DataObject<WindTable>{

    @Override
    public void save(WindTable entity) {
        sqlSave.save(entity);
    }

    @Override
    public WindTable get() {
        return (WindTable) sqlGet.get();
    }
}
