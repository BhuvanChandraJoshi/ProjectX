import { AuthProvider } from "@/lib/context/auth-context";
import "@/styles/globals.scss";
import { NextPage } from "next";
import type { AppProps } from "next/app";
import { ReactElement, ReactNode } from "react";
import { ThemeProvider } from "@/components/common/theme-provider";


type NextPageWithLayout = NextPage & {
  getLayout?: (page: ReactElement) => ReactNode;
};

type AppPropsWithLayout = AppProps & {
  Component: NextPageWithLayout;
};

export default function App({ Component, pageProps }: AppPropsWithLayout) {
  const getLayout = Component.getLayout ?? ((page): ReactNode => page);
  return (
    <AuthProvider>
      <ThemeProvider
        attribute="class"
        defaultTheme="system"
        enableSystem
        disableTransitionOnChange
      >
        {getLayout(<Component {...pageProps} />)}
      </ThemeProvider>
    </AuthProvider>
  );
}
