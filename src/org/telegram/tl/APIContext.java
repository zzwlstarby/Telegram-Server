/*
 *     This file is part of Telegram Server
 *     Copyright (C) 2015  Aykut Alparslan KOÇ
 *
 *     Telegram Server is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Telegram Server is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.telegram.tl;

import java.util.HashMap;

import org.telegram.mtproto.ProtocolBuffer;
import org.telegram.tl.account.*;
import org.telegram.tl.auth.*;
import org.telegram.tl.contacts.*;
import org.telegram.tl.help.*;
import org.telegram.tl.messages.*;
import org.telegram.tl.photos.*;
import org.telegram.tl.pq.*;
import org.telegram.tl.storage.*;
import org.telegram.tl.service.*;
import org.telegram.tl.updates.*;
import org.telegram.tl.upload.File;
import org.telegram.tl.upload.GetFile;
import org.telegram.tl.upload.SaveBigFilePart;
import org.telegram.tl.upload.SaveFilePart;
import org.telegram.tl.users.GetFullUser;
import org.telegram.tl.users.GetUsers;

public class APIContext implements DeserializationContext {
    static APIContext apiContext = null;
    public static APIContext getInstance() {
        if (apiContext == null) {
            apiContext = new APIContext();
        }
        return apiContext;
    }

    private HashMap<Integer, Class> schema;

    private APIContext(){
        addToSchema(AffectedMessages.class);
        addToSchema(ReadHistoryL48.class);
        addToSchema(ReceivedNotifyMessage.class);
        addToSchema(ReceivedMessagesL48.class);
        addToSchema(UpdateShortMessageL48.class);
        addToSchema(UpdateShortChatMessageL48.class);
        addToSchema(ForwardMessagesL48.class);
        addToSchema(SendMessageL48.class);
        addToSchema(SendMediaL48.class);
        addToSchema(InputStickeredMediaDocument.class);
        addToSchema(InputStickeredMediaPhoto.class);
        addToSchema(MaskCoords.class);
        addToSchema(StickerSetInstallResultArchive.class);
        addToSchema(SavedGifsNotModified.class);
        addToSchema(GetAllStickers.class);
        addToSchema(ReorderStickerSets.class);
        addToSchema(InputStickerSetID.class);
        addToSchema(GetSavedGifs.class);
        addToSchema(InputStickerSetShortName.class);
        addToSchema(DocumentAttributeSticker.class);
        addToSchema(GetStickerSet.class);
        addToSchema(StickerSetMultiCovered.class);
        addToSchema(FeaturedStickersNotModified.class);
        addToSchema(UpdateNewStickerSet.class);
        addToSchema(AllStickers.class);
        addToSchema(SavedGifs.class);
        addToSchema(StickerSetCovered.class);
        addToSchema(UpdateStickerSets.class);
        addToSchema(StickerSet.class);
        addToSchema(RecentStickersNotModified.class);
        addToSchema(StickerSet.class);
        addToSchema(StickerSetInstallResultSuccess.class);
        addToSchema(UpdateStickerSetsOrder.class);
        addToSchema(AllStickersNotModified.class);
        addToSchema(InstallStickerSet.class);
        addToSchema(FeaturedStickers.class);
        addToSchema(GetAttachedStickers.class);
        addToSchema(UninstallStickerSet.class);
        addToSchema(ArchivedStickers.class);
        addToSchema(RecentStickers.class);
        addToSchema(InputStickerSetEmpty.class);
        addToSchema(InputPrivacyKeyChatInvite.class);
        addToSchema(GetHistoryL48.class);
        addToSchema(InputChannel.class);
        addToSchema(InputChannelEmpty.class);
        addToSchema(ChatForbiddenL42.class);
        addToSchema(ChatL42.class);
        addToSchema(DialogL42.class);
        addToSchema(DialogChannel.class);
        addToSchema(ReplyInlineMarkup.class);
        addToSchema(DialogsSliceL42.class);
        addToSchema(MessageL48.class);
        addToSchema(DialogsL42.class);
        addToSchema(DialogChannel.class);
        addToSchema(MessageServiceL48.class);
        addToSchema(MessageFwdHeader.class);
        addToSchema(GetDialogsL48.class);
        addToSchema(GetScheme.class);
        addToSchema(TLVector.class);
        addToSchema(message.class);
        addToSchema(msgs_ack.class);
        addToSchema(client_DH_inner_data.class);
        addToSchema(dh_gen_fail.class);
        addToSchema(dh_gen_ok.class);
        addToSchema(dh_gen_retry.class);
        addToSchema(p_q_inner_data.class);
        addToSchema(p_q_inner_data_temp.class);
        addToSchema(req_DH_params.class);
        addToSchema(req_pq.class);
        addToSchema(resPQ.class);
        addToSchema(rsa_public_key.class);
        addToSchema(server_DH_inner_data.class);
        addToSchema(server_DH_params_fail.class);
        addToSchema(server_DH_params_ok.class);
        addToSchema(set_client_DH_params.class);
        addToSchema(InputNotifyPeer.class);
        addToSchema(InputNotifyUsers.class);
        addToSchema(InputNotifyChats.class);
        addToSchema(InputNotifyAll.class);
        addToSchema(UserEmpty.class);
        addToSchema(UserSelf.class);
        addToSchema(UserContact.class);
        addToSchema(UserRequest.class);
        addToSchema(UserForeign.class);
        addToSchema(User.class);
        addToSchema(UserDeleted.class);
        addToSchema(File.class);
        addToSchema(GeoPointEmpty.class);
        addToSchema(GeoPoint.class);
        addToSchema(InputPeerEmpty.class);
        addToSchema(InputPeerSelf.class);
        addToSchema(InputPeerContact.class);
        addToSchema(InputPeerForeign.class);
        addToSchema(InputPeerChat.class);
        addToSchema(ContactsNotModified.class);
        addToSchema(Contacts.class);
        addToSchema(DifferenceEmpty.class);
        addToSchema(Difference.class);
        addToSchema(DifferenceSlice.class);
        addToSchema(EncryptedMessage.class);
        addToSchema(EncryptedMessageService.class);
        addToSchema(InputPhotoEmpty.class);
        addToSchema(InputPhoto.class);
        addToSchema(CheckedPhone.class);
        addToSchema(InputPhotoCropAuto.class);
        addToSchema(InputPhotoCrop.class);
        addToSchema(InputPhoneContact.class);
        addToSchema(WallPaper.class);
        addToSchema(WallPaperSolid.class);
        addToSchema(DcOption.class);
        addToSchema(ContactBlocked.class);
        addToSchema(ChatEmpty.class);
        addToSchema(Chat.class);
        addToSchema(ChatForbidden.class);
        addToSchema(ChatFull.class);
        addToSchema(PhotoSizeEmpty.class);
        addToSchema(PhotoSize.class);
        addToSchema(PhotoCachedSize.class);
        addToSchema(Blocked.class);
        addToSchema(BlockedSlice.class);
        addToSchema(DocumentAttributeImageSize.class);
        addToSchema(DocumentAttributeAnimated.class);
        addToSchema(DocumentAttributeSticker.class);
        addToSchema(DocumentAttributeVideo.class);
        addToSchema(DocumentAttributeAudio.class);
        addToSchema(DocumentAttributeFilename.class);
        addToSchema(ChatPhotoEmpty.class);
        addToSchema(ChatPhoto.class);
        addToSchema(SendMessageTypingAction.class);
        addToSchema(SendMessageCancelAction.class);
        addToSchema(SendMessageRecordVideoAction.class);
        addToSchema(SendMessageUploadVideoAction.class);
        addToSchema(SendMessageRecordAudioAction.class);
        addToSchema(SendMessageUploadAudioAction.class);
        addToSchema(SendMessageUploadPhotoAction.class);
        addToSchema(SendMessageUploadDocumentAction.class);
        addToSchema(SendMessageGeoLocationAction.class);
        addToSchema(SendMessageChooseContactAction.class);
        addToSchema(Null.class);
        addToSchema(Config.class);
        addToSchema(Link.class);
        addToSchema(InputPrivacyValueAllowContacts.class);
        addToSchema(InputPrivacyValueAllowAll.class);
        addToSchema(InputPrivacyValueAllowUsers.class);
        addToSchema(InputPrivacyValueDisallowContacts.class);
        addToSchema(InputPrivacyValueDisallowAll.class);
        addToSchema(InputPrivacyValueDisallowUsers.class);
        addToSchema(BoolFalse.class);
        addToSchema(BoolTrue.class);
        addToSchema(ImportedContacts.class);
        addToSchema(State.class);
        addToSchema(SentMessage.class);
        addToSchema(SentMessageLink.class);
        addToSchema(EncryptedChatEmpty.class);
        addToSchema(EncryptedChatWaiting.class);
        addToSchema(EncryptedChatRequested.class);
        addToSchema(EncryptedChat.class);
        addToSchema(EncryptedChatDiscarded.class);
        addToSchema(Suggested.class);
        addToSchema(ContactFound.class);
        addToSchema(PrivacyKeyStatusTimestamp.class);
        addToSchema(InputFile.class);
        addToSchema(InputFileBig.class);
        addToSchema(Messages.class);
        addToSchema(MessagesSlice.class);
        addToSchema(MessageEmpty.class);
        addToSchema(Message.class);
        addToSchema(MessageForwarded.class);
        addToSchema(MessageService.class);
        addToSchema(Chats.class);
        addToSchema(Photos.class);
        addToSchema(PhotosSlice.class);
        addToSchema(InputEncryptedFileEmpty.class);
        addToSchema(InputEncryptedFileUploaded.class);
        addToSchema(InputEncryptedFile.class);
        addToSchema(InputEncryptedFileBigUploaded.class);
        addToSchema(PeerUser.class);
        addToSchema(PeerChat.class);
        addToSchema(PeerNotifySettingsEmpty.class);
        addToSchema(PeerNotifySettings.class);
        addToSchema(MyLinkEmpty.class);
        addToSchema(MyLinkRequested.class);
        addToSchema(MyLinkContact.class);
        addToSchema(MessageActionEmpty.class);
        addToSchema(MessageActionChatCreate.class);
        addToSchema(MessageActionChatEditTitle.class);
        addToSchema(MessageActionChatEditPhoto.class);
        addToSchema(MessageActionChatDeletePhoto.class);
        addToSchema(MessageActionChatAddUser.class);
        addToSchema(MessageActionChatDeleteUser.class);
        addToSchema(InputMessagesFilterEmpty.class);
        addToSchema(InputMessagesFilterPhotos.class);
        addToSchema(InputMessagesFilterVideo.class);
        addToSchema(InputMessagesFilterPhotoVideo.class);
        addToSchema(InputMessagesFilterPhotoVideoDocuments.class);
        addToSchema(InputMessagesFilterDocument.class);
        addToSchema(InputMessagesFilterAudio.class);
        addToSchema(InputMessagesFilterAudioDocuments.class);
        addToSchema(InputMessagesFilterUrl.class);
        addToSchema(ForeignLinkUnknown.class);
        addToSchema(ForeignLinkRequested.class);
        addToSchema(ForeignLinkMutual.class);
        addToSchema(AudioEmpty.class);
        addToSchema(Audio.class);
        addToSchema(FileUnknown.class);
        addToSchema(FileJpeg.class);
        addToSchema(FileGif.class);
        addToSchema(FilePng.class);
        addToSchema(FilePdf.class);
        addToSchema(FileMp3.class);
        addToSchema(FileMov.class);
        addToSchema(FilePartial.class);
        addToSchema(FileMp4.class);
        addToSchema(FileWebp.class);
        addToSchema(FileLocationUnavailable.class);
        addToSchema(FileLocation.class);
        addToSchema(StickersNotModified.class);
        addToSchema(Stickers.class);
        addToSchema(InputPeerNotifyEventsEmpty.class);
        addToSchema(InputPeerNotifyEventsAll.class);
        addToSchema(AccountDaysTTL.class);
        addToSchema(ImportedContact.class);
        addToSchema(InputVideoEmpty.class);
        addToSchema(InputVideo.class);
        addToSchema(NearestDc.class);
        addToSchema(UserProfilePhotoEmpty.class);
        addToSchema(UserProfilePhoto.class);
        addToSchema(ChatFull.class);
        addToSchema(StickerPack.class);
        addToSchema(SentCode.class);
        addToSchema(SentAppCode.class);
        addToSchema(PrivacyValueAllowContacts.class);
        addToSchema(PrivacyValueAllowAll.class);
        addToSchema(PrivacyValueAllowUsers.class);
        addToSchema(PrivacyValueDisallowContacts.class);
        addToSchema(PrivacyValueDisallowAll.class);
        addToSchema(PrivacyValueDisallowUsers.class);
        addToSchema(ChatParticipant.class);
        addToSchema(MessageMediaEmpty.class);
        addToSchema(MessageMediaPhoto.class);
        addToSchema(MessageMediaVideo.class);
        addToSchema(MessageMediaGeo.class);
        addToSchema(MessageMediaContact.class);
        addToSchema(MessageMediaDocument.class);
        addToSchema(MessageMediaAudio.class);
        addToSchema(EncryptedFileEmpty.class);
        addToSchema(EncryptedFile.class);
        addToSchema(UserStatusEmpty.class);
        addToSchema(UserStatusOnline.class);
        addToSchema(UserStatusOffline.class);
        addToSchema(UserStatusRecently.class);
        addToSchema(UserStatusLastWeek.class);
        addToSchema(UserStatusLastMonth.class);
        addToSchema(AllStickersNotModified.class);
        addToSchema(AllStickers.class);
        addToSchema(InputPrivacyKeyStatusTimestamp.class);
        addToSchema(Found.class);
        addToSchema(InviteText.class);
        addToSchema(DhConfigNotModified.class);
        addToSchema(DhConfig.class);
        addToSchema(SentEncryptedMessage.class);
        addToSchema(SentEncryptedFile.class);
        addToSchema(PhotoEmpty.class);
        addToSchema(Photo.class);
        addToSchema(ChatParticipantsForbidden.class);
        addToSchema(ChatParticipants.class);
        addToSchema(Photo.class);
        addToSchema(InputMediaEmpty.class);
        addToSchema(InputMediaUploadedPhoto.class);
        addToSchema(InputMediaPhoto.class);
        addToSchema(InputMediaGeoPoint.class);
        addToSchema(InputMediaContact.class);
        addToSchema(InputMediaUploadedVideo.class);
        addToSchema(InputMediaUploadedThumbVideo.class);
        addToSchema(InputMediaVideo.class);
        addToSchema(InputMediaUploadedAudio.class);
        addToSchema(InputMediaAudio.class);
        addToSchema(InputMediaUploadedDocument.class);
        addToSchema(InputMediaUploadedThumbDocument.class);
        addToSchema(InputMediaDocument.class);
        addToSchema(UpdatesTooLong.class);
        addToSchema(UpdateShortMessage.class);
        addToSchema(UpdateShortChatMessage.class);
        addToSchema(UpdateShort.class);
        addToSchema(UpdatesCombined.class);
        addToSchema(Updates.class);
        addToSchema(StatedMessages.class);
        addToSchema(StatedMessagesLinks.class);
        addToSchema(Authorization.class);
        addToSchema(Dialogs.class);
        addToSchema(DialogsSlice.class);
        addToSchema(PeerNotifyEventsEmpty.class);
        addToSchema(PeerNotifyEventsAll.class);
        addToSchema(InputPeerNotifySettings.class);
        addToSchema(SentChangePhoneCode.class);
        addToSchema(VideoEmpty.class);
        addToSchema(Video.class);
        addToSchema(InputGeoPointEmpty.class);
        addToSchema(InputGeoPoint.class);
        addToSchema(ContactStatus.class);
        addToSchema(UpdateNewMessage.class);
        addToSchema(UpdateMessageID.class);
        addToSchema(UpdateReadMessages.class);
        addToSchema(UpdateDeleteMessages.class);
        addToSchema(UpdateUserTyping.class);
        addToSchema(UpdateChatUserTyping.class);
        addToSchema(UpdateChatParticipants.class);
        addToSchema(UpdateUserStatus.class);
        addToSchema(UpdateUserName.class);
        addToSchema(UpdateUserPhoto.class);
        addToSchema(UpdateContactRegistered.class);
        addToSchema(UpdateContactLink.class);
        addToSchema(UpdateNewAuthorization.class);
        addToSchema(UpdateNewEncryptedMessage.class);
        addToSchema(UpdateEncryptedChatTyping.class);
        addToSchema(UpdateEncryption.class);
        addToSchema(UpdateEncryptedMessagesRead.class);
        addToSchema(UpdateChatParticipantAdd.class);
        addToSchema(UpdateChatParticipantDelete.class);
        addToSchema(UpdateDcOptions.class);
        addToSchema(UpdateUserBlocked.class);
        addToSchema(UpdateNotifySettings.class);
        addToSchema(UpdateServiceNotification.class);
        addToSchema(UpdatePrivacy.class);
        addToSchema(UpdateUserPhone.class);
        addToSchema(InputAppEvent.class);
        addToSchema(StatedMessage.class);
        addToSchema(StatedMessageLink.class);
        addToSchema(InputEncryptedChat.class);
        addToSchema(NotifyPeer.class);
        addToSchema(NotifyUsers.class);
        addToSchema(NotifyChats.class);
        addToSchema(NotifyAll.class);
        addToSchema(InputFileLocation.class);
        addToSchema(InputVideoFileLocation.class);
        addToSchema(InputEncryptedFileLocation.class);
        addToSchema(InputAudioFileLocation.class);
        addToSchema(InputDocumentFileLocation.class);
        addToSchema(PrivacyRules.class);
        addToSchema(Support.class);
        addToSchema(DocumentEmpty.class);
        addToSchema(Document.class);
        addToSchema(AppUpdate.class);
        addToSchema(NoAppUpdate.class);
        addToSchema(AffectedHistory.class);
        addToSchema(Contact.class);
        addToSchema(UserFull.class);
        addToSchema(DisabledFeature.class);
        addToSchema(Dialog.class);
        addToSchema(Error.class);
        addToSchema(InputUserEmpty.class);
        addToSchema(InputUserSelf.class);
        addToSchema(InputUserContact.class);
        addToSchema(InputUserForeign.class);
        addToSchema(InputUser.class);
        addToSchema(InputAudioEmpty.class);
        addToSchema(InputAudio.class);
        addToSchema(InputDocumentEmpty.class);
        addToSchema(InputDocument.class);
        addToSchema(ExportedAuthorization.class);
        addToSchema(InputChatPhotoEmpty.class);
        addToSchema(InputChatUploadedPhoto.class);
        addToSchema(InputChatPhoto.class);
        addToSchema(ContactSuggested.class);
        addToSchema(GetConfig.class);
        addToSchema(GetAllStickers.class);
        addToSchema(ReceivedMessages.class);
        addToSchema(CreateChat.class);
        addToSchema(SendCode.class);
        addToSchema(GetPrivacy.class);
        addToSchema(GetDifference.class);
        addToSchema(CheckPhone.class);
        addToSchema(SendCall.class);
        addToSchema(SendBroadcast.class);
        addToSchema(SendChangePhoneCode.class);
        addToSchema(GetFile.class);
        addToSchema(RegisterDevice.class);
        addToSchema(EditChatTitle.class);
        addToSchema(GetSupport.class);
        addToSchema(ExportAuthorization.class);
        addToSchema(LogOut.class);
        addToSchema(SetTyping.class);
        addToSchema(ForwardMessages.class);
        addToSchema(GetUserPhotos.class);
        addToSchema(DeletePhotos.class);
        addToSchema(InvokeAfterMsg.class);
        addToSchema(ExportCard.class);
        addToSchema(DeleteContact.class);
        addToSchema(ImportCard.class);
        addToSchema(ImportContacts.class);
        addToSchema(SendSms.class);
        addToSchema(AddChatUser.class);
        addToSchema(SendMessage.class);
        addToSchema(SendInvites.class);
        addToSchema(ResetAuthorizations.class);
        addToSchema(GetInviteText.class);
        addToSchema(GetState.class);
        addToSchema(SaveAppLog.class);
        addToSchema(org.telegram.tl.messages.Search.class);
        addToSchema(SaveBigFilePart.class);
        addToSchema(GetFullUser.class);
        addToSchema(SendEncrypted.class);
        addToSchema(ReceivedQueue.class);
        addToSchema(UpdateProfilePhoto.class);
        addToSchema(ChangePhone.class);
        addToSchema(SetPrivacy.class);
        addToSchema(DeleteAccount.class);
        addToSchema(UpdateStatus.class);
        addToSchema(SaveFilePart.class);
        addToSchema(UploadProfilePhoto.class);
        addToSchema(Block.class);
        addToSchema(DeleteContacts.class);
        addToSchema(BindTempAuthKey.class);
        addToSchema(GetUsers.class);
        addToSchema(UpdateDeviceLocked.class);
        addToSchema(DeleteMessages.class);
        addToSchema(ResetNotifySettings.class);
        addToSchema(SetAccountTTL.class);
        addToSchema(GetBlocked.class);
        addToSchema(GetStickers.class);
        addToSchema(UpdateUsername.class);
        addToSchema(DeleteChatUser.class);
        addToSchema(EditChatPhoto.class);
        addToSchema(GetAccountTTL.class);
        addToSchema(GetAppUpdate.class);
        addToSchema(UpdateProfile.class);
        addToSchema(SendEncryptedService.class);
        addToSchema(GetSuggested.class);
        addToSchema(GetMessages.class);
        addToSchema(GetNotifySettings.class);
        addToSchema(InitConnection.class);
        addToSchema(GetChats.class);
        addToSchema(ReadHistory.class);
        addToSchema(GetDhConfig.class);
        addToSchema(RequestEncryption.class);
        addToSchema(SendEncryptedFile.class);
        addToSchema(InvokeWithLayer.class);
        addToSchema(org.telegram.tl.contacts.Search.class);
        addToSchema(Unblock.class);
        addToSchema(GetWallPapers.class);
        addToSchema(GetNearestDc.class);
        addToSchema(SendMedia.class);
        addToSchema(SendMediaL25.class);
        addToSchema(ImportAuthorization.class);
        addToSchema(DiscardEncryption.class);
        addToSchema(ReadMessageContents.class);
        addToSchema(GetFullChat.class);
        addToSchema(InvokeAfterMsgs.class);
        addToSchema(ResolveUsername.class);
        addToSchema(GetStatuses.class);
        addToSchema(UpdateNotifySettings.class);
        addToSchema(GetContacts.class);
        addToSchema(ReadEncryptedHistory.class);
        addToSchema(GetHistory.class);
        addToSchema(DeleteHistory.class);
        addToSchema(UnregisterDevice.class);
        addToSchema(SignUp.class);
        addToSchema(SignIn.class);
        addToSchema(CheckUsername.class);
        addToSchema(SetEncryptedTyping.class);
        addToSchema(ForwardMessage.class);
        addToSchema(AcceptEncryption.class);
        addToSchema(GetDialogs.class);
        addToSchema(ReportSpam.class);
        addToSchema(new_session_created.class);
        addToSchema(msgs_all_info.class);
        addToSchema(msg_resend_ans_req.class);
        addToSchema(ping_delay_disconnect.class);
        addToSchema(bad_server_salt.class);
        addToSchema(rpc_answer_dropped_running.class);
        addToSchema(gzip_packed.class);
        addToSchema(Pong.class);
        addToSchema(msg_resend_req.class);
        addToSchema(msg_container.class);
        addToSchema(rpc_drop_answer.class);
        addToSchema(http_wait.class);
        addToSchema(future_salts.class);
        addToSchema(Ping.class);
        addToSchema(msg_detailed_info.class);
        addToSchema(destroy_session_ok.class);
        addToSchema(rpc_answer_unknown.class);
        addToSchema(rpc_result.class);
        addToSchema(msg_copy.class);
        addToSchema(destroy_session_none.class);
        addToSchema(msgs_state_info.class);
        addToSchema(future_salt.class);
        addToSchema(msg_new_detailed_info.class);
        addToSchema(rpc_error.class);
        addToSchema(destroy_session.class);
        addToSchema(msgs_ack.class);
        addToSchema(rpc_answer_dropped.class);
        addToSchema(msgs_state_req.class);
        addToSchema(get_future_salts.class);
        addToSchema(bad_msg_notification.class);
        addToSchema(InputPeerUser.class);
        addToSchema(KeyboardButton.class);
        addToSchema(KeyboardButtonRow.class);
        addToSchema(ReplyKeyboardForceReply.class);
        addToSchema(ReplyKeyboardHide.class);
        addToSchema(ReplyKeyboardMarkup.class);
        addToSchema(MessageEntityBold.class);
        addToSchema(MessageEntityBotCommand.class);
        addToSchema(MessageEntityCode.class);
        addToSchema(MessageEntityEmail.class);
        addToSchema(MessageEntityHashtag.class);
        addToSchema(MessageEntityItalic.class);
        addToSchema(MessageEntityMention.class);
        addToSchema(MessageEntityPre.class);
        addToSchema(MessageEntityTextUrl.class);
        addToSchema(MessageEntityUnknown.class);
        addToSchema(MessageEntityUrl.class);
        addToSchema(DocumentL12.class);
        addToSchema(MessageMediaVideoL12.class);
        addToSchema(MessageMediaVenue.class);
        addToSchema(VideoL15.class);
        addToSchema(VideoL28.class);
        addToSchema(VideoL12.class);
        addToSchema(AudioL15.class);
        addToSchema(MessageMediaVideo.class);
        addToSchema(MessageMediaDocument.class);
        addToSchema(AudioL12.class);
        addToSchema(PhotoL12.class);
        addToSchema(MessageMediaWebPage.class);
        addToSchema(MessageMediaUnsupported.class);
        addToSchema(MessageMediaPhotoL12.class);
        addToSchema(PhotoL28.class);
        addToSchema(MessageMediaPhoto.class);
        addToSchema(MessageMediaAudio.class);
        addToSchema(MessageMediaUnsupportedL12.class);
    }

    @Override
    public <T extends TLObject> void addToSchema(Class<T> type) {
        try {
            if(schema == null){
                schema = new HashMap<>();
            }
            int constructor = type.getField("ID").getInt(null);
            schema.put(constructor, type);
        } catch (Exception e) {

        }
    }

    @Override
    public TLObject deserialize(ProtocolBuffer buffer) {
        int constructor = buffer.readInt();
        Class obj = schema.get(constructor);
        if (obj != null) {
            TLObject req;
            try {
                req = (TLObject) obj.newInstance();
            } catch (Exception e) {
                return null;
            }
            req.deserialize(buffer);
            return req;
        } else {
            System.out.println("constructor: " + Integer.toHexString(constructor) + " not found");
        }
        return null;
    }
}