package work.download.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import work.download.delivery.Delivery;
import work.download.delivery.DeliveryRepository;
import work.download.storage.FilesStorageService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Component
public class MyInterceptor implements HandlerInterceptor {

    public static final String TMP_RESOURCE_ID_HEADER = "Tmp-ID";

    private final FilesStorageService filesStorageService;
    private final DeliveryRepository deliveryRepository;

    public MyInterceptor(FilesStorageService filesStorageService, DeliveryRepository deliveryRepository) {
        this.filesStorageService = filesStorageService;
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if(response == null || !response.containsHeader(TMP_RESOURCE_ID_HEADER)) return;
        String tmpFileId = response.getHeader(TMP_RESOURCE_ID_HEADER);

        System.out.println("storage service: " + (filesStorageService != null));

        Optional<Delivery> byId = deliveryRepository.findById(Long.parseLong(tmpFileId));

        if(byId.isEmpty()) return;

        filesStorageService.cleanDecryptedFiles(byId.get());

    }
}