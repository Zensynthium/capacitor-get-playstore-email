export interface GetPlaystoreEmailPlugin {
  getAccount(): Promise<{ email: string }>;
}
