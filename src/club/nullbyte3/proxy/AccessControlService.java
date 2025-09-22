package club.nullbyte3.proxy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AccessControlService {
    private static AccessControlService instance;
    private final Map<String, Set<String>> permissions = new HashMap<>();

    private AccessControlService() {}

    public static synchronized AccessControlService getInstance() {
        if (instance == null) {
            instance = new AccessControlService();
        }
        return instance;
    }

    public boolean isAllowed(String docId, String username) {
        Set<String> allowedUsers = permissions.get(docId);
        return allowedUsers != null && allowedUsers.contains(username);
    }

    public void grantAccess(String docId, String username) {
        permissions.computeIfAbsent(docId, k -> new HashSet<>()).add(username);
    }
}
