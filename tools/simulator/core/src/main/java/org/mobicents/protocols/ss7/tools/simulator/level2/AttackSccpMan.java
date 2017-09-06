package org.mobicents.protocols.ss7.tools.simulator.level2;

import org.apache.log4j.Level;
import org.mobicents.protocols.ss7.indicator.NatureOfAddress;
import org.mobicents.protocols.ss7.indicator.NumberingPlan;
import org.mobicents.protocols.ss7.indicator.RoutingIndicator;
import org.mobicents.protocols.ss7.mtp.Mtp3UserPart;
import org.mobicents.protocols.ss7.sccp.*;
import org.mobicents.protocols.ss7.sccp.impl.SccpStackImpl;
import org.mobicents.protocols.ss7.sccp.impl.router.RouterImpl;
import org.mobicents.protocols.ss7.sccp.parameter.GlobalTitle;
import org.mobicents.protocols.ss7.sccp.parameter.ParameterFactory;
import org.mobicents.protocols.ss7.sccp.parameter.SccpAddress;
import org.mobicents.protocols.ss7.sccp.Router;
import org.mobicents.protocols.ss7.tools.simulator.Stoppable;
import org.mobicents.protocols.ss7.tools.simulator.management.AttackTesterHost;

/**
 * @author Kristoffer Jensen
 */
public class AttackSccpMan extends SccpMan implements Stoppable {

    public static String SOURCE_NAME = "SCCP";

    private final String name;
    private AttackTesterHost testerHost;

    private Mtp3UserPart mtp3UserPart;

    private SccpStackImpl sccpStack;
    private SccpProvider sccpProvider;
    private ParameterFactory parameterFactory;
    private SccpResource resource;
    private Router router;
    private boolean isRspcUp = true;
    private boolean isRssUp = true;

    public AttackSccpMan() {
        this.name = "???";
    }

    public AttackSccpMan(String name) {
        this.name = name;
    }

    public void setTesterHost(AttackTesterHost testerHost) {
        this.testerHost = testerHost;
    }

    public void setMtp3UserPart(Mtp3UserPart val) {
        this.mtp3UserPart = val;
    }

    public SccpStack getSccpStack() {
        return (SccpStack)this.sccpStack;
    }

    public boolean isRouteOnGtMode() {
        return this.testerHost.getConfigurationData().getSccpConfigurationData().isRouteOnGtMode();
    }

    public void setRouteOnGtMode(boolean val) {
        this.testerHost.getConfigurationData().getSccpConfigurationData().setRouteOnGtMode(val);
        this.testerHost.markStore();
    }

    public int getRemoteSpc() {
        return this.testerHost.getConfigurationData().getSccpConfigurationData().getRemoteSpc();
    }

    public void setRemoteSpc(int val) {
        this.testerHost.getConfigurationData().getSccpConfigurationData().setRemoteSpc(val);
        this.testerHost.markStore();
    }

    public int getLocalSpc() {
        return this.testerHost.getConfigurationData().getSccpConfigurationData().getLocalSpc();
    }

    public void setLocalSpc(int val) {
        this.testerHost.getConfigurationData().getSccpConfigurationData().setLocalSpc(val);
        this.testerHost.markStore();
    }

    public int getNi() {
        return this.testerHost.getConfigurationData().getSccpConfigurationData().getNi();
    }

    public void setNi(int val) {
        this.testerHost.getConfigurationData().getSccpConfigurationData().setNi(val);
        this.testerHost.markStore();
    }

    public int getRemoteSsn() {
        return this.testerHost.getConfigurationData().getSccpConfigurationData().getRemoteSsn();
    }

    public void setRemoteSsn(int val) {
        this.testerHost.getConfigurationData().getSccpConfigurationData().setRemoteSsn(val);
        this.testerHost.markStore();
    }

    public int getLocalSsn() {
        return this.testerHost.getConfigurationData().getSccpConfigurationData().getLocalSsn();
    }

    public void setLocalSsn(int val) {
        this.testerHost.getConfigurationData().getSccpConfigurationData().setLocalSsn(val);
        this.testerHost.markStore();
    }

    public GlobalTitleType getGlobalTitleType() {
        return this.testerHost.getConfigurationData().getSccpConfigurationData().getGlobalTitleType();
    }

    public String getGlobalTitleType_Value() {
        return this.testerHost.getConfigurationData().getSccpConfigurationData().getGlobalTitleType().toString();
    }

    public void setGlobalTitleType(GlobalTitleType val) {
        this.testerHost.getConfigurationData().getSccpConfigurationData().setGlobalTitleType(val);
        this.testerHost.markStore();
    }

    public NatureOfAddressType getNatureOfAddress() {
        return new NatureOfAddressType(this.testerHost.getConfigurationData().getSccpConfigurationData().getNatureOfAddress()
                .getValue());
    }

    public String getNatureOfAddress_Value() {
        return this.testerHost.getConfigurationData().getSccpConfigurationData().getNatureOfAddress().toString();
    }

    public void setNatureOfAddress(NatureOfAddressType val) {
        this.testerHost.getConfigurationData().getSccpConfigurationData()
                .setNatureOfAddress(NatureOfAddress.valueOf(val.intValue()));
        this.testerHost.markStore();
    }

    public NumberingPlanSccpType getNumberingPlan() {
        return new NumberingPlanSccpType(this.testerHost.getConfigurationData().getSccpConfigurationData().getNumberingPlan()
                .getValue());
    }

    public String getNumberingPlan_Value() {
        return this.testerHost.getConfigurationData().getSccpConfigurationData().getNumberingPlan().toString();
    }

    public void setNumberingPlan(NumberingPlanSccpType val) {
        this.testerHost.getConfigurationData().getSccpConfigurationData()
                .setNumberingPlan(NumberingPlan.valueOf(val.intValue()));
        this.testerHost.markStore();
    }

    public SccpProtocolVersionType getSccpProtocolVersion() {
        return new SccpProtocolVersionType(this.testerHost.getConfigurationData().getSccpConfigurationData().getSccpProtocolVersion().getValue());
    }

    public String getSccpProtocolVersion_Value() {
        return this.testerHost.getConfigurationData().getSccpConfigurationData().getSccpProtocolVersion().toString();
    }

    public void setSccpProtocolVersion(SccpProtocolVersionType val) {
        this.testerHost.getConfigurationData().getSccpConfigurationData().setSccpProtocolVersion(SccpProtocolVersion.valueOf(val.intValue()));
        this.testerHost.markStore();
    }

    public int getTranslationType() {
        return this.testerHost.getConfigurationData().getSccpConfigurationData().getTranslationType();
    }

    public void setTranslationType(int val) {
        this.testerHost.getConfigurationData().getSccpConfigurationData().setTranslationType(val);
        this.testerHost.markStore();
    }

    public String getCallingPartyAddressDigits() {
        return this.testerHost.getConfigurationData().getSccpConfigurationData().getCallingPartyAddressDigits();
    }

    public void setCallingPartyAddressDigits(String val) {
        this.testerHost.getConfigurationData().getSccpConfigurationData().setCallingPartyAddressDigits(val);
        this.testerHost.markStore();
    }

    public void putGlobalTitleType(String val) {
        GlobalTitleType x = GlobalTitleType.createInstance(val);
        if (x != null)
            this.setGlobalTitleType(x);
    }

    public void putNatureOfAddress(String val) {
        NatureOfAddressType x = NatureOfAddressType.createInstance(val);
        if (x != null)
            this.setNatureOfAddress(x);
    }

    public void putNumberingPlan(String val) {
        NumberingPlanSccpType x = NumberingPlanSccpType.createInstance(val);
        if (x != null)
            this.setNumberingPlan(x);
    }

    public void putSccpProtocolVersion(String val) {
        SccpProtocolVersionType x = SccpProtocolVersionType.createInstance(val);
        if (x != null)
            this.setSccpProtocolVersion(x);
    }

    @Override
    public String getState() {
        StringBuilder sb = new StringBuilder();
        sb.append("SCCP: Rspc: ");
        sb.append(this.isRspcUp ? "Enabled" : "Disabled");
        sb.append("  Rss: ");
        sb.append(this.isRssUp ? "Enabled" : "Disabled");
        return sb.toString();
    }

    public boolean start() {
        try {
            this.isRspcUp = true;
            this.isRssUp = true;
            this.initSccp(this.mtp3UserPart, this.testerHost.getConfigurationData().getSccpConfigurationData().getRemoteSsn(), this.testerHost
                            .getConfigurationData().getSccpConfigurationData().getLocalSsn(), this.testerHost.getConfigurationData().getSccpConfigurationData()
                            .getRemoteSpc(), this.testerHost.getConfigurationData().getSccpConfigurationData().getRemoteSpc2(), this.testerHost.getConfigurationData().getSccpConfigurationData().getLocalSpc(),
                            this.testerHost.getConfigurationData().getSccpConfigurationData().getLocalSpc2(), this.testerHost.getConfigurationData()
                            .getSccpConfigurationData().getNi(), this.testerHost.getConfigurationData().getSccpConfigurationData().getCallingPartyAddressDigits(),
                    this.testerHost.getPersistDir(), this.testerHost.getConfigurationData().getSccpConfigurationData().getSccpProtocolVersion());
            this.testerHost.sendNotif(SOURCE_NAME, "SCCP has been started", "", Level.INFO);
            return true;
        } catch (Throwable e) {
            this.testerHost.sendNotif(SOURCE_NAME, "Exception when starting AttackSccpMan", e, Level.ERROR);
            return false;
        }
    }

    @Override
    public void stop() {
        try {
            this.stopSccp();
            this.testerHost.sendNotif(SOURCE_NAME, "SCCP has been stopped", "", Level.INFO);
        } catch (Exception e) {
            this.testerHost.sendNotif(SOURCE_NAME, "Exception when stopping AttackSccpMan", e, Level.ERROR);
        }
    }

    @Override
    public void execute() {
        if (this.resource != null) {
            RemoteSignalingPointCode rspc = this.resource.getRemoteSpc(1);
            RemoteSubSystem rss = this.resource.getRemoteSsn(1);
            if (rspc != null) {
                boolean conn = !rspc.isRemoteSpcProhibited();
                if (this.isRspcUp != conn) {
                    this.isRspcUp = conn;
                    this.testerHost.sendNotif(SOURCE_NAME, "SCCP RemoteSignalingPoint is " + (conn ? "enabled" : "disabled"),
                            "Dpc=" + this.testerHost.getConfigurationData().getSccpConfigurationData().getRemoteSpc(),
                            Level.INFO);
                }
            }
            if (rss != null) {
                boolean conn = !rss.isRemoteSsnProhibited();
                if (this.isRssUp != conn) {
                    this.isRssUp = conn;
                    this.testerHost.sendNotif(SOURCE_NAME, "SCCP RemoteSubSystem is " + (conn ? "enabled" : "disabled"), "Dpc="
                            + this.testerHost.getConfigurationData().getSccpConfigurationData().getRemoteSpc() + " Ssn="
                            + this.testerHost.getConfigurationData().getSccpConfigurationData().getRemoteSsn(), Level.INFO);
                }
            }
        }
    }

    private void initSccp(Mtp3UserPart mtp3UserPart, int remoteSsn, int localSsn, int dpc, int dpc2, int opc, int opc2, int ni, String callingPartyAddressDigits, String persistDir, SccpProtocolVersion sccpProtocolVersion)
            throws Exception {
        this.sccpStack = new SccpStackImpl("TestingSccp");
        this.sccpStack.setPersistDir(persistDir);

        this.sccpStack.setMtp3UserPart(1, mtp3UserPart);
        this.sccpStack.start();
        this.sccpStack.removeAllResourses();

        this.sccpStack.setSccpProtocolVersion(sccpProtocolVersion);
        this.sccpStack.getRouter().addMtp3ServiceAccessPoint(1, 1, opc, ni, 0);
        this.sccpStack.getRouter().addMtp3Destination(1, 1, dpc, dpc, 0, 255, 255);

        if(this.testerHost.getConfigurationData().getSccpConfigurationData().getLocalSpc2() > 0 &&
                this.testerHost.getConfigurationData().getSccpConfigurationData().getRemoteSpc2() > 0) {
            this.sccpStack.getRouter().addMtp3ServiceAccessPoint(2, 1, opc2, ni, 0);
            this.sccpStack.getRouter().addMtp3Destination(1, 2, dpc2, dpc2, 0, 255, 255);
        }

        this.sccpProvider = this.sccpStack.getSccpProvider();
        this.parameterFactory = this.sccpProvider.getParameterFactory();
        // router1 = sccpStack1.getRouter();

        this.resource = this.sccpStack.getSccpResource();

        this.resource.addRemoteSpc(1, dpc, 0, 0);
        this.resource.addRemoteSsn(1, dpc, remoteSsn, 0, false);

        if(this.testerHost.getConfigurationData().getSccpConfigurationData().getRemoteSpc2() > 0) {
            this.resource.addRemoteSpc(2, dpc2, 0, 0);
            this.resource.addRemoteSsn(2, dpc2, remoteSsn, 0, false);
        }

        if (this.testerHost.getConfigurationData().getSccpConfigurationData().isRouteOnGtMode()) {
            this.router = this.sccpStack.getRouter();

            this.router.addRoutingAddress(1,parameterFactory.createSccpAddress(RoutingIndicator.ROUTING_BASED_ON_GLOBAL_TITLE, this.createGlobalTitle(""), dpc, 0));
            this.router.addRoutingAddress(2,
                    parameterFactory.createSccpAddress(RoutingIndicator.ROUTING_BASED_ON_DPC_AND_SSN, this.createGlobalTitle(""), opc, localSsn));


            SccpAddress pattern = parameterFactory.createSccpAddress(RoutingIndicator.ROUTING_BASED_ON_GLOBAL_TITLE, this.createGlobalTitle("*"), 0,
                    0);
            String mask = "K";
            ((RouterImpl) this.router).addRule(1, RuleType.SOLITARY, null, OriginationType.LOCAL, pattern, mask, 1,
                    -1, null, 0);
            pattern = parameterFactory.createSccpAddress(RoutingIndicator.ROUTING_BASED_ON_GLOBAL_TITLE, this.createGlobalTitle("*"), 0, 0);
            mask = "R";
            ((RouterImpl) this.router).addRule(2, RuleType.SOLITARY, null, OriginationType.REMOTE, pattern, mask, 2,
                    -1, null, 0);

            if(this.testerHost.getConfigurationData().getSccpConfigurationData().getLocalSpc2() > 0 &&
                    this.testerHost.getConfigurationData().getSccpConfigurationData().getRemoteSpc2() > 0) {

                this.router.addRoutingAddress(3, parameterFactory.createSccpAddress(RoutingIndicator.ROUTING_BASED_ON_GLOBAL_TITLE, this.createGlobalTitle(""), dpc2, 0));
                this.router.addRoutingAddress(4,
                        parameterFactory.createSccpAddress(RoutingIndicator.ROUTING_BASED_ON_DPC_AND_SSN, this.createGlobalTitle(""), opc2, localSsn));

                pattern = parameterFactory.createSccpAddress(RoutingIndicator.ROUTING_BASED_ON_GLOBAL_TITLE,
                        this.createGlobalTitle("*"), 0, 0);
                mask = "L";
                ((RouterImpl) this.router).addRule(3, RuleType.SOLITARY, null, OriginationType.LOCAL, pattern,
                        mask, 3, -1, null, 0);
                pattern = parameterFactory.createSccpAddress(RoutingIndicator.ROUTING_BASED_ON_GLOBAL_TITLE,
                        this.createGlobalTitle("*"), 0, 0);
                mask = "S";
                ((RouterImpl) this.router).addRule(4, RuleType.SOLITARY, null, OriginationType.REMOTE, pattern,
                        mask, 4, -1, null, 0);
            }

        }
    }

    private void stopSccp() {

        this.sccpStack.removeAllResourses();
        this.sccpStack.stop();
    }

    public SccpAddress createCallingPartyAddress() {

        if (this.testerHost.getConfigurationData().getSccpConfigurationData().isRouteOnGtMode()) {
            return parameterFactory.createSccpAddress(RoutingIndicator.ROUTING_BASED_ON_GLOBAL_TITLE, createGlobalTitle(this.testerHost
                    .getConfigurationData().getSccpConfigurationData().getCallingPartyAddressDigits()), 0, this.testerHost
                    .getConfigurationData().getSccpConfigurationData().getLocalSsn());
        } else {
            return parameterFactory.createSccpAddress(RoutingIndicator.ROUTING_BASED_ON_DPC_AND_SSN, null, this.testerHost.getConfigurationData()
                    .getSccpConfigurationData().getLocalSpc(), this.testerHost.getConfigurationData()
                    .getSccpConfigurationData().getLocalSsn());
        }
    }

    public SccpAddress createCalledPartyAddress() {
        return parameterFactory.createSccpAddress(RoutingIndicator.ROUTING_BASED_ON_DPC_AND_SSN, null, this.testerHost.getConfigurationData()
                .getSccpConfigurationData().getRemoteSpc(), this.testerHost.getConfigurationData()
                .getSccpConfigurationData().getRemoteSsn());
    }

    public SccpAddress createCalledPartyAddress(String address, int ssn) {
        if (this.testerHost.getConfigurationData().getSccpConfigurationData().isRouteOnGtMode()) {
            return parameterFactory.createSccpAddress(RoutingIndicator.ROUTING_BASED_ON_GLOBAL_TITLE, createGlobalTitle(address),0,
                    (ssn >= 0 ? ssn : this.testerHost.getConfigurationData().getSccpConfigurationData().getRemoteSsn()));
        } else {
            return createCalledPartyAddress();
        }
    }

    public GlobalTitle createGlobalTitle(String address) {
        GlobalTitle gt = null;
        switch (this.testerHost.getConfigurationData().getSccpConfigurationData().getGlobalTitleType().intValue()) {
            case GlobalTitleType.VAL_NOA_ONLY:
                gt = this.parameterFactory.createGlobalTitle(address,this.testerHost.getConfigurationData().getSccpConfigurationData()
                        .getNatureOfAddress());
                break;
            case GlobalTitleType.VAL_TT_ONLY:
                gt = this.parameterFactory.createGlobalTitle(address,this.testerHost.getConfigurationData().getSccpConfigurationData()
                        .getTranslationType());
                break;
            case GlobalTitleType.VAL_TT_NP_ES:
                gt = this.parameterFactory.createGlobalTitle(address,this.testerHost.getConfigurationData().getSccpConfigurationData()
                        .getTranslationType(), this.testerHost.getConfigurationData().getSccpConfigurationData()
                        .getNumberingPlan(), null);
                break;
            case GlobalTitleType.VAL_TT_NP_ES_NOA:
                gt = this.parameterFactory.createGlobalTitle(address,this.testerHost.getConfigurationData().getSccpConfigurationData()
                        .getTranslationType(), this.testerHost.getConfigurationData().getSccpConfigurationData()
                        .getNumberingPlan(),null, this.testerHost.getConfigurationData().getSccpConfigurationData()
                        .getNatureOfAddress());
                break;
        }
        return gt;
    }

    // public SccpAddress createDestAddress() {
    // return parameterFactory.createSccpAddress(RoutingIndicator.ROUTING_BASED_ON_DPC_AND_SSN, this.remotePc, null, this.remoteSsn);
    // }

}
