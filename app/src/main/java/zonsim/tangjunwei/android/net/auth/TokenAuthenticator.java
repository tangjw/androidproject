package zonsim.tangjunwei.android.net.auth;

import java.io.IOException;

import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

/**
 * desc
 * <p>
 * Created by tangjunwei on 2018/3/12.
 * <a href="mailto:tjwabc@gmail.com">Contact me</a>
 * <a href="https://github.com/tangjw">Follow me</a>
 */
public class TokenAuthenticator implements Authenticator {
    @Override
    public Request authenticate(Route route, Response response) throws IOException {
        return null;
    }
}
