package gaojing.activitytest;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaojing on 16-4-18.
 */
/* 在活动管理器中，我们通过一个List来暂存活动，
 * 然后提供了一个addActivity()方法用于向List中添加一个活动，即将当前正在创建的活动增加到活动管理器里
 * 提供了一个removeActivity()方法用于从List中移除活动
 * 最后提供了一个finishAll()方法用于将List中存储的活动全部都小毁掉。
 */
public class ActivityCollector {
    public static List<Activity> activities = new ArrayList<Activity>();
    public static void  addActivity(Activity activity) {
        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public static void finishAll() {
        for (Activity activity:activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }

}
