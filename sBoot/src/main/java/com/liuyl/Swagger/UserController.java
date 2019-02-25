package com.liuyl.Swagger;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by liuyanlei on 2018/4/23.
 */
@RestController
@RequestMapping(value="/User1s")     // 通过这里配置使下面的映射都在/User1s下，可去除
public class UserController {

    static Map<Long, User1> User1s = Collections.synchronizedMap(new HashMap<Long, User1>());

    @ApiOperation(value="获取用户列表", notes="")
    @RequestMapping(value={""}, method= RequestMethod.GET)
    public List<User1> getUser1List() {
        List<User1> r = new ArrayList<User1>(User1s.values());
        return r;
    }

    @ApiOperation(value="创建用户", notes="根据User1对象创建用户")
    @ApiImplicitParam(name = "User1", value = "用户详细实体User1", required = true, dataType = "User1")
    @RequestMapping(value="", method=RequestMethod.POST)
    public String postUser1(@RequestBody User1 User1) {
        User1s.put(User1.getId(), User1);
        return "success";
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public User1 getUser1(@PathVariable Long id) {
        return User1s.get(id);
    }

    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的User1信息来更新用户详细信息")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
        @ApiImplicitParam(name = "User1", value = "用户详细实体User1", required = true, dataType = "User1")
    })
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String putUser1(@PathVariable Long id, @RequestBody User1 User1) {
        User1 u = User1s.get(id);
        u.setName(User1.getName());
        u.setAge(User1.getAge());
        User1s.put(id, u);
        return "success";
    }

    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUser1(@PathVariable Long id) {
        User1s.remove(id);
        return "success";
    }

}