package com.javashun.cloud.module.infra.controller.admin.server;

import com.javashun.cloud.framework.common.pojo.CommonResult;
import com.javashun.cloud.framework.common.pojo.PageResult;
import com.javashun.cloud.module.infra.controller.admin.server.vo.ServerHardwareCreateReqVO;
import com.javashun.cloud.module.infra.controller.admin.server.vo.ServerHardwarePageReqVO;
import com.javashun.cloud.module.infra.controller.admin.server.vo.ServerHardwareRespVO;
import com.javashun.cloud.module.infra.controller.admin.server.vo.ServerHardwareUpdateReqVO;
import com.javashun.cloud.module.infra.convert.server.ServerHardwareConvert;
import com.javashun.cloud.module.infra.dal.dataobject.server.ServerHardwareDO;
import com.javashun.cloud.module.infra.service.server.ServerHardwareService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

import static com.javashun.cloud.framework.common.pojo.CommonResult.success;

@Tag(name =  "管理后台 - 硬件服务器信息")
@RestController
@RequestMapping("/infra/server-hardware")
@Validated
public class ServerHardwareController {

    @Resource
    private ServerHardwareService serverHardwareService;

    @PostMapping("/create")
    @Operation(summary = "创建硬件服务器信息")
    @PreAuthorize("@ss.hasPermission('infra:test-demo:create')")
    public CommonResult<Long> createServerHardware(@Valid @RequestBody ServerHardwareCreateReqVO createReqVO) {
        return success(serverHardwareService.createServerHardware(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新硬件服务器信息")
    @PreAuthorize("@ss.hasPermission('infra:test-demo:update')")
    public CommonResult<Boolean> updateServerHardware(@Valid @RequestBody ServerHardwareUpdateReqVO updateReqVO) {
        serverHardwareService.updateServerHardware(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除硬件服务器信息")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('infra:test-demo:delete')")
    public CommonResult<Boolean> deleteServerHardware(@RequestParam("id") Long id) {
        serverHardwareService.deleteServerHardware(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得硬件服务器信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('infra:test-demo:query')")
    public CommonResult<ServerHardwareRespVO> getServerHardware(@RequestParam("id") Long id) {
        ServerHardwareDO serverHardware = serverHardwareService.getServerHardware(id);
        return success(ServerHardwareConvert.INSTANCE.convert(serverHardware));
    }

    @GetMapping("/list")
    @Operation(summary = "获得硬件服务器信息")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('infra:test-demo:query')")
    public CommonResult<List<ServerHardwareRespVO>> getServerHardwareList(@RequestParam("ids") Collection<Long> ids) {
        List<ServerHardwareDO> list = serverHardwareService.getServerHardwareList(ids);
        return success(ServerHardwareConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得硬件服务器信息分页")
    @PreAuthorize("@ss.hasPermission('infra:test-demo:query')")
    public CommonResult<PageResult<ServerHardwareRespVO>> getServerHardwarePage(@Valid ServerHardwarePageReqVO pageVO) {
        PageResult<ServerHardwareDO> pageResult = serverHardwareService.getServerHardwarePage(pageVO);
        return success(ServerHardwareConvert.INSTANCE.convertPage(pageResult));
    }
}