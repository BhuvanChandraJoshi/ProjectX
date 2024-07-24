import Image from "next/image";
import { Inter } from "next/font/google";
import { SEO } from "@/components/common/seo";
import { LoginMain } from "@/components/login/login-main";
import { ReactElement, ReactNode } from "react";
import { AuthLayout } from "@/components/layout/auth-layout";
import { LoginFooter } from "@/components/login/login-footer";

const inter = Inter({ subsets: ["latin"] });

export default function Login(): JSX.Element {
  return (
    <div className="grid min-h-screen grid-rows-[1fr,auto]">
      <SEO
        title="ProjectX - It’s what’s happening"
        description="From breaking news and entertainment to sports and politics, get the full story with all the live commentary."
      />
      <LoginMain />
      <LoginFooter />
    </div>
  );
}

Login.getLayout = (page: ReactElement): ReactNode => (
  <AuthLayout>{page}</AuthLayout>
);