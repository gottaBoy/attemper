package com.github.attemper.common.param.dispatch.trigger.sub;

import com.github.attemper.common.param.CommonParam;
import com.github.attemper.java.sdk.common.util.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class CommonTriggerParam implements CommonParam {

    protected String triggerName;

    protected String triggerType;

    protected String description;

    protected Date startTime;

    protected Date endTime;

    protected List<String> calendarNames;

    @Override
    public String validate() {
        if (StringUtils.isBlank(triggerName)) {
            return "6100";
        }
        if (startTime != null && endTime != null && !startTime.before(endTime)) {
            return "6110";
        }
        return null;
    }
}
